package com.nextuple.learning.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document(collection="transactions")
public class Transaction {

    @Id
    private String transactionId;
    private String name;
    private Long accountNumber;
    private String email;
    private String contact;
    private int amount;
    private int cashback;
    private String dateAndTime;
    private String username;

}
