package ru.tupi.lunchvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.tupi.lunchvoting.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    @RestResource(rel = "by-user", path = "by-user")
    List<Vote> findByUserId(int userId);

    @RestResource(rel = "by-restaurant", path = "by-restaurant")
    List<Vote> findByRestaurantId(int restaurantId);

    @RestResource(rel = "by-day", path = "by-day")
    List<Vote> findByDay(LocalDate day);
}
