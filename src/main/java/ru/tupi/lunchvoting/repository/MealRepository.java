package ru.tupi.lunchvoting.repository;

import org.springframework.transaction.annotation.Transactional;
import ru.tupi.lunchvoting.model.Meal;

@Transactional(readOnly = true)
public interface MealRepository extends BaseRepository<Meal> {
}
