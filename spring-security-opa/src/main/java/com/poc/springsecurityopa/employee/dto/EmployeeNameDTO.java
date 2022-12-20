package com.poc.springsecurityopa.employee.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class EmployeeNameDTO {
    String firstName;
    String lastName;
}
