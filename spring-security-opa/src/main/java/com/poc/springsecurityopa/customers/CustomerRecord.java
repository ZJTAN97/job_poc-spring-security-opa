package com.poc.springsecurityopa.customers;

import com.poc.springsecurityopa.common.enums.Gender;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Document(value = "customer")
@TypeAlias("customer") // does not record the full class name in the "_class" field in mongodb
public class CustomerRecord {

    @Id
    private String id;

    private String username;

    private String email;

    private String bio;

    private Gender gender;

    @Version
    private Long version;

}
