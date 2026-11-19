package ru.dmc3105.service;

import ru.dmc3105.domain.user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserService {
    private final List<User> users = new ArrayList<>();

    public void registerUser(RegisterUserCommand cmd)
    {
        users.add(User.withPersonalData(cmd.name(),  cmd.age()));
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}
