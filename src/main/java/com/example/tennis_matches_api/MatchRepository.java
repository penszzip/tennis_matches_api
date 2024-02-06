package com.example.tennis_matches_api;

import org.springframework.data.jpa.repository.JpaRepository;

interface MatchRepository extends JpaRepository<Match, Long> {

}
