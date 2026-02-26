package com.SubscriptionManager.repositories;

import com.SubscriptionManager.models.Subscription;
import com.SubscriptionManager.models.enums.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {
    // Para buscar la suscripción activa de un usuario
    List<Subscription> findByUserIdAndStatus(UUID userId, SubscriptionStatus status);
}
