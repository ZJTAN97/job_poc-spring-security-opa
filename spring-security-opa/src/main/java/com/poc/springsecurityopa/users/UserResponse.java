package com.poc.springsecurityopa.users;

import com.poc.springsecurityopa.common.enums.Gender;

public record UserResponse (
    String id,
    String username,
    String bio,
    Gender gender,
    Long version
) {}

