package com.cricket.fantasy_cricket.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "cricClient", url = "https://api.cricapi.com/v1")
public interface CricApiClient {

    @GetMapping("/currentMatches")
    Map<String, Object> getMatches(
            @RequestParam("apikey") String apiKey,
            @RequestParam("offset") int offset
    );
}

