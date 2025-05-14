package com.cricket.fantasy_cricket.controller;

import com.cricket.fantasy_cricket.service.LiveScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class LiveScoreController {

    private final LiveScoreService liveScoreService;

    @GetMapping("/live-scores")
    public ResponseEntity<?> getLiveScores() {
        try {
            log.info("Inside try block of controller");
            return ResponseEntity.ok(liveScoreService.fetchLiveMatches());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                    .body(Map.of("error", "Unable to fetch live scores"));
        }
    }
}

