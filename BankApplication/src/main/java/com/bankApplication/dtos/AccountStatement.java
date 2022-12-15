package com.bankApplication.dtos;

import com.bankApplication.Entities.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountStatement {
    BigDecimal currentBalance;
    List<Transaction> transactionHistory;
}