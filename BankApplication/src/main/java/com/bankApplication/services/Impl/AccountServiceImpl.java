package com.bankApplication.services.Impl;

import com.bankApplication.Controllers.requests.TransferBalanceRequest;
import com.bankApplication.Entities.Account;
import com.bankApplication.Entities.Transaction;
import com.bankApplication.dtos.AccountStatement;
import com.bankApplication.dtos.response.Response;
import com.bankApplication.repositories.AccountRepository;
import com.bankApplication.repositories.TransactionRepository;
import com.bankApplication.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Account> findAll(){
        return accountRepository.findAll();
    }


    @Override
    public Account save(Account account){
        accountRepository.save(account);
        return accountRepository.findByAccountNumberEquals(account.getAccountNumber());
    }

    @Override
    public Object[] sendMoney(
            TransferBalanceRequest transferBalanceRequest
    ) {
        String fromAccountNumber = transferBalanceRequest.getFromAccountNumber();
        String toAccountNumber = transferBalanceRequest.getToAccountNumber();
        BigDecimal amount = transferBalanceRequest.getAmount();
        Account fromAccount = accountRepository.findByAccountNumberEquals(
                fromAccountNumber
        );
        Account toAccount = accountRepository.findByAccountNumberEquals(toAccountNumber);
        if(fromAccount.getCurrentBalance().compareTo(BigDecimal.ONE) == 1
                && fromAccount.getCurrentBalance().compareTo(amount) == 1
        ){
            fromAccount.setCurrentBalance(fromAccount.getCurrentBalance().subtract(amount));
            accountRepository.save(fromAccount);
            toAccount.setCurrentBalance(toAccount.getCurrentBalance().add(amount));
            accountRepository.save(toAccount);
            Transaction transaction = transactionRepository.save(new Transaction(0L,fromAccountNumber,amount));

            Transaction transaction2 = transactionRepository.save(new Transaction(0L,toAccountNumber, amount.negate()));
            return new Object[]{transaction, transaction2};

        }
        return new Response[]{Response.badRequest()};
    }

    @Override
    public AccountStatement getStatement(String accountNumber) {
        Account account = accountRepository.findByAccountNumberEquals(accountNumber);
        return new AccountStatement(account.getCurrentBalance(),transactionRepository.findByAccountNumberEquals(accountNumber));
    }
}
