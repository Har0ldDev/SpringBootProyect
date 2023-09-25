package com.example.project01.controllers;

import com.example.project01.dao.UserDao;
import com.example.project01.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "api/users/{id}" , method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setName("Harold");
        user.setLastname("Venegas");
        user.setEmail("ronaldo89k@gmail.com");
        user.setPhone("992333555");
        return user;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userDao.getUsers();
    }


    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUsers(@RequestBody User user) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,user.getPassword());
        user.setPassword(hash);

        userDao.register(user);
    }

    @RequestMapping(value = "user12")
    public User edit() {
        User user = new User();
        user.setName("Harold");
        user.setLastname("Venegas");
        user.setEmail("ronaldo89k@gmail.com");
        user.setPhone("992333555");
        return user;
    }

    @RequestMapping(value = "api/users/{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        userDao.delete(id);
    }

    @RequestMapping(value = "user56")
    public User search() {
        User user = new User();
        user.setName("Harold");
        user.setLastname("Venegas");
        user.setEmail("ronaldo89k@gmail.com");
        user.setPhone("992333555");
        return user;
    }
}
