package com.example.tennis_matches_api.service;

import com.example.tennis_matches_api.Match;
import com.example.tennis_matches_api.MatchRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebScraperService {
    //use MatchRepository to change database
    private final MatchRepository repository;
    public WebScraperService(MatchRepository repository) {
        this.repository = repository;
    }
    public void scrapeAndPopulate() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.skysports.com/tennis/scores-schedule/06-02-2024");

        List<WebElement> matches = driver.findElements(By.className("ui-tennis-match-score__table"));

        repository.deleteAll();

        String template9 = "%s-%s,%s-%s";
        String template12 = "%s-%s,%s-%s,%s-%s";

        for (WebElement match : matches) {
            String[] lines = match.getText().split("\n");
            if (lines.length == 9) {
                String score = String.format(template9, lines[2], lines[4], lines[5], lines[7]);
                String winner = lines[8].substring(0, lines[8].length() - 5);
                Match newMatch = new Match(lines[0], lines[1], score, winner);
                repository.save(newMatch);
            }
            else if (lines.length == 11) {
                String score = String.format(template9, lines[4], lines[6], lines[7], lines[9]);
                String winner = lines[10].substring(0, lines[10].length() - 4);
                Match newMatch = new Match(lines[0] + ',' + lines[1], lines[2] + ',' + lines[3], score, winner);
                repository.save(newMatch);
            }
            else if (lines.length == 12) {
                String score = String.format(template12, lines[2], lines[4], lines[5], lines[7], lines[8], lines[10]);
                String winner = lines[11].substring(0, lines[11].length() - 5);
                Match newMatch = new Match(lines[0], lines[1], score, winner);
                repository.save(newMatch);
            }
            else if (lines.length == 14) {
                String score = String.format(template12, lines[4], lines[6], lines[7], lines[9], lines[10], lines[12]);
                String winner = lines[13].substring(0, lines[13].length() - 4);
                Match newMatch = new Match(lines[0] + ',' + lines[1], lines[2] + ',' + lines[3], score, winner);
                repository.save(newMatch);
            }
        }

        driver.quit();
    }
}
