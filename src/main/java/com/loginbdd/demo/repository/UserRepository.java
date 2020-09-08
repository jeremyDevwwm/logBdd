package com.loginbdd.demo.repository;
import com.loginbdd.demo.entities.testUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Ce repository va gérer les requêtes vers la BDD
 * Dans le cadre d'une recherche par username la query a été faite main afin de cibler plus facilement les données
 * recherchées
 */

@Repository
public interface UserRepository extends JpaRepository<testUser, Long> {

    @Query("SELECT u FROM testUser u WHERE u.username=:username")
    testUser findByUsername(String username);
}
