package com.cricket.fantasy_cricket.service;

import com.cricket.fantasy_cricket.entity.Match;
import com.cricket.fantasy_cricket.entity.Team;
import com.cricket.fantasy_cricket.entity.User;
import com.cricket.fantasy_cricket.repository.MatchRepository;
import com.cricket.fantasy_cricket.repository.TeamRepository;
import com.cricket.fantasy_cricket.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;
    private final UserRepository userRepository;

    public Team createTeam(Long userId, Long matchId, List<String> players) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        Match match = matchRepository.findById(matchId)
            .orElseThrow(() -> new RuntimeException("Match not found"));

        Team team = new Team();
        team.setUser(user);
        team.setMatch(match);
        team.setPlayers(players);
        return teamRepository.save(team);
    }
}
