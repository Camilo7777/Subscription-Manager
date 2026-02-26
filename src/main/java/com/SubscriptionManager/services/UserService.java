package com.SubscriptionManager.services;


import com.SubscriptionManager.dtos.UserRequestDTO;
import com.SubscriptionManager.dtos.UserResponseDTO;
import com.SubscriptionManager.mappers.UserMapper;
import com.SubscriptionManager.models.Plan;
import com.SubscriptionManager.models.User;
import com.SubscriptionManager.repositories.PlanRepository;
import com.SubscriptionManager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PlanRepository planRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, PlanRepository planRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.planRepository = planRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDTO saveUser(UserRequestDTO dto) {
        // 1. Buscamos el plan en la BD usando el ID que viene en el DTO
        Plan plan = planRepository.findById(dto.getPlanId())
                .orElseThrow(() -> new RuntimeException("Error: El Plan con ID " + dto.getPlanId() + " no existe."));

        // 2. Usamos el Mapper para convertir DTO a Entidad (el plan se ignora en el mapper)
        User user = userMapper.toEntity(dto);

        // 3. Asignamos manualmente el plan que encontramos
        user.setPlan(plan);

        // 4. Guardamos en la base de datos
        User savedUser = userRepository.save(user);

        // 5. Devolvemos el ResponseDTO (que ya incluye el nombre del plan gracias a MapStruct)
        return userMapper.toDto(savedUser);
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserResponseDTO findById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return userMapper.toDto(user);
    }
}