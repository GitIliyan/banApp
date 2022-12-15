package com.bankApplication.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class TransactionDto {
    private String accountNumber;

    private BigDecimal transactionAmount;
}
