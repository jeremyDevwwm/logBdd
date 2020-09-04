package com.loginbdd.demo.repository;
import com.loginbdd.demo.entities.testUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<testUser, Long> {

    @Query("SELECT u FROM testUser u WHERE u.username=:username")
    testUser findByUsername(String username);
}
