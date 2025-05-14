package com.cricket.fantasy_cricket.service;

import com.cricket.fantasy_cricket.client.CricApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class LiveScoreService {


    private static final String API_KEY = "ed456df1-a1b0-4d3d-8f0e-6a6626a56f8a";

    private final CricApiClient cricApiClient;

    public LiveScoreService(CricApiClient cricApiClient) {
        this.cricApiClient = cricApiClient;
    }

    public Map<String, Object> fetchLiveMatches() {
        log.info("Fetching live matches from CricApi (service)");
        return cricApiClient.getMatches(API_KEY, 0);
    }
}

