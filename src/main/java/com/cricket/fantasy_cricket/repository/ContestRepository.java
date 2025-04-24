package com.cricket.fantasy_cricket.repository;

import com.cricket.fantasy_cricket.entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContestRepository extends JpaRepository<Contest, Long> {
    List<Contest> findByMatchId(Long matchId);
}
