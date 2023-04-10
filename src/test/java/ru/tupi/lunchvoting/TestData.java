package ru.tupi.lunchvoting;

import ru.tupi.lunchvoting.model.Restaurant;
import ru.tupi.lunchvoting.model.Role;
import ru.tupi.lunchvoting.model.User;
import ru.tupi.lunchvoting.model.Vote;

import java.time.LocalDate;
import java.util.Set;

public class TestData {
    public static final int ADMIN_ID = 100001;
    public static final int USER_ID = 100002;
    public static final int GUEST_ID = 100003;

    public static final String ADMIN_EMAIL = "admin@lunchvoting.ru";
    public static final String USER_EMAIL = "user@gmail.com";
    public static final String GUEST_EMAIL = "guest@gmail.com";

    public static final User admin = new User(ADMIN_ID, "Admin", ADMIN_EMAIL, "{noop}admin", Set.of(Role.ADMIN, Role.USER), null);
    public static final User user = new User(USER_ID, "User", USER_EMAIL, "{noop}password", Set.of(Role.USER), null);
    public static final User guest = new User(GUEST_ID, "Guest", GUEST_EMAIL, "{noop}password", Set.of(), null);

    public static final int RESTAURANT_1_ID = 100011;
    public static final int RESTAURANT_2_ID = 100012;

    public static final Restaurant restaurant1 = new Restaurant(RESTAURANT_1_ID, "RESTAURANT_1", null, null);
    public static final Restaurant restaurant2 = new Restaurant(RESTAURANT_2_ID, "RESTAURANT_2", null, null);

    public static final LocalDate DAY_1 = LocalDate.of(2001, 1, 1);
    public static final LocalDate DAY_2 = LocalDate.of(2001, 1, 2);

    public static final Vote vote1 = new Vote(100031, admin, restaurant1, DAY_1);
    public static final Vote vote2 = new Vote(100032, admin, restaurant1, DAY_2);
    public static final Vote vote3 = new Vote(100033, user, restaurant1, DAY_1);
    public static final Vote vote4 = new Vote(100034, guest, restaurant1, DAY_1);
}
