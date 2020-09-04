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

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository repo;

    @Autowired
    PasswordEncoder passwordEncoder;


    public testUser addPerson(testUser user){
        testUser userBdd =  new testUser();

        userBdd.setUsername(user.getUsername());
        userBdd.setPassword(passwordEncoder.encode(user.getPassword()));

        return repo.save(userBdd);
    }

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
