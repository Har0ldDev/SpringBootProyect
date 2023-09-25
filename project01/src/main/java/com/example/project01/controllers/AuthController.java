package com.example.project01.controllers;

import com.example.project01.dao.UserDao;
import com.example.project01.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.project01.utils.JWTUtil;


@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {

        User userLogged = userDao.obtainUserForCredentials(user);


        if(userLogged != null) {

            return jwtUtil.create(String.valueOf(userLogged.getId()), userLogged.getEmail());


        };
        return "FAIL";
    }

}
