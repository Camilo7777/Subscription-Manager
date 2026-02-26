package com.SubscriptionManager.dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter @Setter
public class SubscriptionRequestDTO {
    private UUID userId;
    private UUID planId;
}