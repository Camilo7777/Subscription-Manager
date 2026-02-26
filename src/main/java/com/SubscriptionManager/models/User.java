package com.SubscriptionManager.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username; // Cambiado de userName a username
    private String email;
        private String password;


    // RELACIÓN: Muchos usuarios pueden estar en un mismo plan
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;

}