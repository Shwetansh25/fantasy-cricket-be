package com.cricket.fantasy_cricket.repository;

import com.cricket.fantasy_cricket.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {}

