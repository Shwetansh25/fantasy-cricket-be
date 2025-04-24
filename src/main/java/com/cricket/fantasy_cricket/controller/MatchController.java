package com.cricket.fantasy_cricket.controller;

import com.cricket.fantasy_cricket.entity.Match;
import com.cricket.fantasy_cricket.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {
    private final MatchService matchService;

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        return ResponseEntity.ok(matchService.createMatch(match));
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }
}
