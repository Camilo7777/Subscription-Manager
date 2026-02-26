package com.SubscriptionManager.dtos;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
public class SubscriptionResponseDTO {
    private UUID id;
    private String userName;
    private String planName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
}