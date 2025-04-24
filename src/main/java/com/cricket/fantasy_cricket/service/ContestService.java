package com.cricket.fantasy_cricket.service;

import com.cricket.fantasy_cricket.entity.Contest;
import com.cricket.fantasy_cricket.entity.Match;
import com.cricket.fantasy_cricket.repository.ContestRepository;
import com.cricket.fantasy_cricket.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContestService {
    private final ContestRepository contestRepository;
    private final MatchRepository matchRepository;

    public Contest createContest(Long matchId, Contest contest) {
        Match match = matchRepository.findById(matchId)
            .orElseThrow(() -> new RuntimeException("Match not found"));
        contest.setMatch(match);
        return contestRepository.save(contest);
    }

    public List<Contest> getContestsByMatch(Long matchId) {
        return contestRepository.findByMatchId(matchId);
    }
}
