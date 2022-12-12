package com.poc.springsecurityopa.employee.domain;

import com.poc.springsecurityopa.common.Country;
import com.poc.springsecurityopa.common.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@TypeAlias("employee")
@Builder
@Document(collection = "employee")
@NoArgsConstructor
@AllArgsConstructor
public class Employee  {
    @MongoId
    String id;
    Gender gender;
    String employeeName;
    String bioNotes;
    Country nationality;

}
