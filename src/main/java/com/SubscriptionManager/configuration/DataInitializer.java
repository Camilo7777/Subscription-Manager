package com.SubscriptionManager.configuration;

import com.SubscriptionManager.models.Plan;
import com.SubscriptionManager.repositories.PlanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(PlanRepository planRepository) {
        return args -> {
            // VALIDACIÓN: Solo actúa si no hay planes
            if (planRepository.count() == 0) {
                Plan gratis = new Plan();
                gratis.setName("GRATIS");
                gratis.setPrice(0.0);
                gratis.setDurationDays(365);
                gratis.setMaxStorageGb(5);

                Plan premium = new Plan();
                premium.setName("PREMIUM");
                premium.setPrice(9.99);
                premium.setDurationDays(30);
                premium.setMaxStorageGb(50);

                planRepository.saveAll(List.of(gratis, premium));
                System.out.println(">> Catálogo de planes inicializado (Primera vez).");
            } else {
                System.out.println(">> Los planes ya existen en la BD, saltando inicialización.");
            }
        };
    }
}