package com.nextuple.learning.backend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Document("wallet")
public class Recharge {

    private Integer amount;
    @Id
    private String username;
    private String timeStamp;

}
