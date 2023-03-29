package ru.tupi.lunchvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.tupi.lunchvoting.model.Meal;

@Transactional(readOnly = true)
public interface MealRepository extends JpaRepository<Meal, Integer> {
}
