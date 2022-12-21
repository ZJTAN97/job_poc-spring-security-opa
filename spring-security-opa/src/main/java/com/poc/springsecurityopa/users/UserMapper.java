package com.poc.springsecurityopa.users;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserResponse toDto(UserRecord userRecord);

    List<UserResponse> toDto(List<UserRecord> userRecords);

    UserRecord toDomainObject(UserRequest userRequest);

}
