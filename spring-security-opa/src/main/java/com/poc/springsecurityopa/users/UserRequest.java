package com.poc.springsecurityopa.users;

import com.poc.springsecurityopa.common.enums.Gender;

public record UserRequest(
    String username,
    String email,
    Gender gender
) {
}
