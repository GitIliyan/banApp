package com.bankApplication.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AccountDto {

    private Integer id;
    private String accountName;
    private LocalDateTime createDate;
    private String accountNumber;
    private BigDecimal currentBalance;
}
