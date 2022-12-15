package com.bankApplication.Entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Account extends baseEntity {

    private String accountName;
    private LocalDateTime createDate;
    private String accountNumber;
    private BigDecimal currentBalance;
}
