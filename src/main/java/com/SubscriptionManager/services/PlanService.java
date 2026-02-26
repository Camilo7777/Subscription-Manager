package com.SubscriptionManager.services;

import com.SubscriptionManager.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService {

    @Autowired
    private  PlanRepository planRepository;


}
