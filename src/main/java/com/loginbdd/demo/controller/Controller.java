package com.loginbdd.demo.controller;

import com.loginbdd.demo.entities.testUser;
import com.loginbdd.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {

    @Autowired
    UserService service;

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }


    @PostMapping("/addUser")
    public testUser addingUser(testUser user){
        return service.addPerson(user);
    }



}
