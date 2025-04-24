package com.cricket.fantasy_cricket.controller;

import com.cricket.fantasy_cricket.entity.Contest;
import com.cricket.fantasy_cricket.service.ContestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contests")
@RequiredArgsConstructor
public class ContestController {
    private final ContestService contestService;

    @PostMapping("/match/{matchId}")
    public ResponseEntity<Contest> createContest(@PathVariable Long matchId, @RequestBody Contest contest) {
        return ResponseEntity.ok(contestService.createContest(matchId, contest));
    }

    @GetMapping("/match/{matchId}")
    public List<Contest> getContestsForMatch(@PathVariable Long matchId) {
        return contestService.getContestsByMatch(matchId);
    }
}
