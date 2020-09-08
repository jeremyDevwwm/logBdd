package com.loginbdd.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

/**
 * testUser est l'entité utilisateur (dans le cadre du projet : l'admin et d'éventuels éditeurs si besoin est)
 * Il n'y a pas encore de gestion de rôle, mais celà pourrait être gérée par une enum ou une tabe en plus
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "testUser")
public class testUser {

    /**
     * L'id a été déclaré par l'annotation @Id, disant à spring qu'il s'agit de l'id d'une table
     * Generated value stipule que l'id ne se verra pas octroyé une valeur lors de la création d'une nouvelle entité
     * Lombok gère les getters et les setters (assurés par les annotation ci dessus)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;


    private String password;




}
