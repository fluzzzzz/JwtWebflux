package ru.example.webfluxsecurity.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.example.webfluxsecurity.dto.UserDto;
import ru.example.webfluxsecurity.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto map(UserEntity userEntity);

    @InheritInverseConfiguration
    UserEntity map(UserDto dto);
}