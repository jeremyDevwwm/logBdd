package com.loginbdd.demo.controller;

import com.loginbdd.demo.entities.testUser;
import com.loginbdd.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
/**
 * Le controlleur va gérer les chemins vers les différentes functionnalités
 */
public class Controller {

    /**
     * autoconstruction de UserService
     */

    @Autowired
    UserService service;

    /**
     * Le end point pourra être remplacé par la page basique du site internet
     * @return hello world (à changer)
     */
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    /**
     * Cette fonction permet d'ajouter un utilisateur dans la BDD en passant par l'API
     * @param user fait référence à l'utilisateur entré dans l'URL
     * @return renvoie les infos de l'utilisateur vers la BDD
     */
    @PostMapping("/addUser")
    public testUser addingUser(testUser user){
        return service.addPerson(user);
    }



}
