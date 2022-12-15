package com.bankApplication.Controllers;

import com.bankApplication.Controllers.requests.AccountStatementRequest;
import com.bankApplication.Controllers.requests.TransferBalanceRequest;
import com.bankApplication.Entities.Account;
import com.bankApplication.dtos.AccountDto;
import com.bankApplication.dtos.response.Response;
import com.bankApplication.services.AccountService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/account")
public class AccountController extends BaseController {
    @Autowired private AccountService accountService;
    @RequestMapping("/create")
    public ResponseEntity<AccountDto> create(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(modelMapper.map
                (accountService.save(modelMapper.map(accountDto, Account.class)),
                        AccountDto.class),
                HttpStatus.CREATED);
    }


    @RequestMapping("/all")
    public List<AccountDto> all() {

        return accountService.findAll().parallelStream().
                map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());
    }

    @RequestMapping("/send money")
    public Response sendMoney(
            @RequestBody TransferBalanceRequest transferBalanceRequest
    ) {

        return Response.ok().setPayload(
                accountService.sendMoney(
                        transferBalanceRequest
                )
        );
    }
    @RequestMapping("/statement")
    public Response getStatement(
            @RequestBody @NotNull AccountStatementRequest accountStatementRequest

    ){
        return Response.ok().setPayload(
                accountService.getStatement(accountStatementRequest.getAccountNumber())
        );

    }

}
