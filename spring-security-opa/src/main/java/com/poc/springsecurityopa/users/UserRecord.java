package com.poc.springsecurityopa.users;

import com.poc.springsecurityopa.common.enums.Gender;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Document(value = "user")
@TypeAlias("user") // does not record the full class name in the "_class" field in mongodb
public class UserRecord {

    @Id
    private String id;

    private String username;

    private String email;

    private String bio;

    private Gender gender;

    @Version
    private Long version;

}
