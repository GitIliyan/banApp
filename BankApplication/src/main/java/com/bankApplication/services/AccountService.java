package com.bankApplication.services;

import com.bankApplication.Controllers.requests.TransferBalanceRequest;
import com.bankApplication.Entities.Account;
import com.bankApplication.dtos.AccountStatement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<Account> findAll();
    Account save(Account account);
    Object[] sendMoney(
            TransferBalanceRequest transferBalanceRequest
    );
    AccountStatement getStatement(String accountNumber);
}