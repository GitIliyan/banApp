package com.bankApplication.Entities;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction extends baseEntity{

    private String accountNumber;

    private BigDecimal transactionAmount;


    public Transaction(long l, String fromAccountNumber, BigDecimal amount) {
        super();
    }
}
