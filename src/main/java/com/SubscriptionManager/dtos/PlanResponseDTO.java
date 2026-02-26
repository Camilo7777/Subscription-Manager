package com.SubscriptionManager.dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter @Setter
public class PlanResponseDTO {
    private UUID id;
    private String name;
    private Double price;
    private Integer durationDays;
}