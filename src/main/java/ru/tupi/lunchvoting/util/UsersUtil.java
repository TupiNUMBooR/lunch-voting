package ru.tupi.lunchvoting.util;

import lombok.experimental.UtilityClass;
import ru.tupi.lunchvoting.model.Role;
import ru.tupi.lunchvoting.model.User;
import ru.tupi.lunchvoting.to.UserTo;

import java.util.Set;

@UtilityClass
public class UsersUtil {

    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getName(), userTo.getEmail().toLowerCase(), userTo.getPassword(), Set.of(Role.USER), null);
    }

    public static User updateFromTo(User user, UserTo userTo) {
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail().toLowerCase());
        user.setPassword(userTo.getPassword());
        return user;
    }
}