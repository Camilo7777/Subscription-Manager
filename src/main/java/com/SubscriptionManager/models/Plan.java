package com.SubscriptionManager.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "plans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name; // Ejemplo: "BASIC", "PREMIUM", "ENTERPRISE"

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer durationDays; // Duración del plan (ej: 30, 365)

    // Un campo extra para mostrar nivel: límites del plan
    private Integer maxStorageGb;

    private Boolean supportPriority;

    // RELACIÓN INVERSA (Opcional pero útil):
    // Esto permite que desde un Plan puedas ver todas sus suscripciones activas
    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;
}

