package com.bankApplication.Controllers.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AccountStatementRequest {
    private String accountNumber;
}