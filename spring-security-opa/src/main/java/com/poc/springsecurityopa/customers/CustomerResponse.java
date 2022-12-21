package com.poc.springsecurityopa.customers;

import com.poc.springsecurityopa.common.enums.Gender;

public record CustomerResponse(
    String id,
    String username,
    String bio,
    Gender gender,
    Long version
) {}

