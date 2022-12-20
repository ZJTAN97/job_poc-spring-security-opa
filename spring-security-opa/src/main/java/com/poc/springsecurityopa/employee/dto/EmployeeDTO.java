package com.poc.springsecurityopa.employee.dto;

import com.poc.springsecurityopa.common.Country;
import com.poc.springsecurityopa.common.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@NoArgsConstructor
@FieldNameConstants
@EqualsAndHashCode
public class EmployeeDTO {
 String id;
 Gender gender;
 EmployeeNameDTO employeeName;
 String bioNotes;
 Country nationality;
}
