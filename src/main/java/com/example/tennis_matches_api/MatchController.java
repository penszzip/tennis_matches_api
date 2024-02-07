package com.example.tennis_matches_api;

import com.azure.core.annotation.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {
    private final MatchRepository repository;

    public MatchController(MatchRepository repository) {
        this.repository = repository;
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

}
