package com.example.tennis_matches_api;

import com.azure.core.annotation.Post;
import com.example.tennis_matches_api.service.WebScraperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {
    private final MatchRepository repository;
    private final WebScraperService webScraperService;

    public MatchController(MatchRepository repository, WebScraperService webScraperService) {
        this.repository = repository;
        this.webScraperService = webScraperService;
    }

    @GetMapping("/matches")
    public List<Match> all() {
        return repository.findAll();
    }

    @GetMapping("/matches/{id}")
    public Match one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MatchNotFoundException(id));
    }

    @PostMapping("/scrape")
    public ResponseEntity<String> scrape() {
        webScraperService.scrapeAndPopulate();
        return ResponseEntity.ok("Service run was successful");
    }

}
