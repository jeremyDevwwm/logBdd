package com.loginbdd.demo.services;
import com.loginbdd.demo.entities.testUser;
import com.loginbdd.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

/**
 * Ce service va gérer les différentes interaction entre les données utilisateurs véhiculées par l'API.
 * Ces dernières circuleront en interne dans le framework, et iront:
 * Soit en BDD dans le cadre d'un save
 * Soit vers le front dans le cadre d'un get ou d'un login
 */

@Service
public class UserService implements UserDetailsService {

    /**
     * Autoconstruction du repository
     * Cela nous permettra de nous servir des requêtes préfaites dans le framework (Magique n'est-ce pas ?)
     */
    @Autowired
    UserRepository repo;

    /**
     * Autoconstruction d'un objet encoder
     * Cela nous permettra de crypter le mot de passe ou le decrypter selon l'état
     */
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Cette fonction permettra de gérer l'ajout d'un utilisateur en bdd
     * @param user => correspond à l'utilisateur passé en infos
     * @return
     */
    public testUser addPerson(testUser user){
        testUser userBdd =  new testUser();

        userBdd.setUsername(user.getUsername());
        userBdd.setPassword(passwordEncoder.encode(user.getPassword()));

        return repo.save(userBdd);
    }

    /**
     * Cette fonction va gérer la connexion
     * On recherche l'utilisateur par son username
     * @param username => :) ...
     * @return l'utilisateur sous la forme d'un cookie de session
     * @throws UsernameNotFoundException => :) ...
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        testUser user = repo.findByUsername(username);

        if (user == null) {
            System.out.println("Ca voit que dalle");
            throw new UsernameNotFoundException("No user present with username : " + username);
        } else {
            System.out.println("On est là !");
            return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
        }
    }

}
