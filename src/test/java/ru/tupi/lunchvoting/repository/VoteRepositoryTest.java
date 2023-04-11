package ru.tupi.lunchvoting.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.tupi.lunchvoting.TestData.*;

@SpringBootTest
@ActiveProfiles("test")
class VoteRepositoryTest {
    @Autowired
    VoteRepository repo;

    @Test
    void findByUserId() {
        var current = repo.findByUserId(ADMIN_ID);
        assertThat(current)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("user", "restaurant")
                .isEqualTo(List.of(vote1, vote2));
    }

    @Test
    void findByRestaurantId() {
        var current = repo.findByRestaurantId(RESTAURANT_1_ID);
        assertThat(current)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("user", "restaurant")
                .isEqualTo(List.of(vote1, vote2, vote3, vote4));
    }

    @Test
    void findByDay() {
        var current = repo.findByDay(DAY_1);
        assertThat(current)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("user", "restaurant")
                .isEqualTo(List.of(vote1, vote3, vote4));
    }
}