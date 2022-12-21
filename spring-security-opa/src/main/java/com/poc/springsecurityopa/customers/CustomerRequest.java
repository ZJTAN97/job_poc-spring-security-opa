package com.poc.springsecurityopa.customers;

import com.poc.springsecurityopa.common.enums.Gender;

public record CustomerRequest(
    String username,
    String email,
    Gender gender
) {
}
