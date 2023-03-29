package ru.tupi.lunchvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.tupi.lunchvoting.model.Vote;

@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
