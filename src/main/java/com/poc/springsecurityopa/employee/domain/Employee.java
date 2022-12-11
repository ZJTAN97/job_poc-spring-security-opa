package com.poc.springsecurityopa.employee.domain;

import com.poc.springsecurityopa.common.Country;
import com.poc.springsecurityopa.common.Gender;
import com.poc.springsecurityopa.common.References;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@EqualsAndHashCode(callSuper = true)
@Data
@TypeAlias("employee")
@SuperBuilder(toBuilder = true)
@Document(collection = "employee")
@NoArgsConstructor
public class Employee extends References {
    @MongoId
    String id;
    Gender gender;
    String employeeName;
    String bioNotes;
    Country nationality;

}
