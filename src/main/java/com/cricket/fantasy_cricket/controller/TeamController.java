package com.cricket.fantasy_cricket.controller;

import com.cricket.fantasy_cricket.entity.Team;
import com.cricket.fantasy_cricket.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping("/user/{userId}/match/{matchId}")
    public ResponseEntity<Team> createTeam(
        @PathVariable Long userId,
        @PathVariable Long matchId,
        @RequestBody List<String> players
    ) {
        return ResponseEntity.ok(teamService.createTeam(userId, matchId, players));
    }
}
