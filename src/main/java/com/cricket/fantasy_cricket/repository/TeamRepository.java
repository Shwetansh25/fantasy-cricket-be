package com.cricket.fantasy_cricket.repository;

import com.cricket.fantasy_cricket.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByUserIdAndMatchId(Long userId, Long matchId);
}
