package com.example.userservice.mapper;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserDto userDto);

    UserDto toDto(RequestUser user);

    UserDto toDto(UserEntity userEntity);

    ResponseUser toResponseUser(UserDto userDto);

    ResponseUser toResponseUser(UserEntity v);
}
