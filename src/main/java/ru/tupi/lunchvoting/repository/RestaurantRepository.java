package ru.tupi.lunchvoting.repository;

import org.springframework.transaction.annotation.Transactional;
import ru.tupi.lunchvoting.model.Restaurant;

@Transactional(readOnly = true)
public interface RestaurantRepository extends BaseRepository<Restaurant> {
}
