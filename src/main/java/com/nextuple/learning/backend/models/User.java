package com.nextuple.learning.backend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection="users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
@Data
public class User {

    private String name;
    @Id
    private String email;
    private String phone;
    private String password;

}
