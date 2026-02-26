package com.SubscriptionManager.mappers;

import com.SubscriptionManager.dtos.UserRequestDTO;
import com.SubscriptionManager.dtos.UserResponseDTO;
import com.SubscriptionManager.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Entidad -> ResponseDTO (Para mostrar datos)
    @Mapping(source = "plan.name", target = "planName")
    UserResponseDTO toDto(User user);

    // RequestDTO -> Entidad (Para guardar en BD)
    @Mapping(target = "id", ignore = true) // El ID lo genera la BD
    @Mapping(target = "plan", ignore = true) // El plan lo buscaremos manualmente en el Service
    User toEntity(UserRequestDTO dto);
}