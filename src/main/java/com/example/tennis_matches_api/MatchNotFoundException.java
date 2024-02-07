package com.example.tennis_matches_api;

public class MatchNotFoundException extends RuntimeException {
    MatchNotFoundException(Long id) {
        super("Match not found" + id);
    }
}
