package com.example.project01.dao;
import com.example.project01.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void delete(Long id);

    void register(User user);

    User obtainUserForCredentials(User user);
}
