package com.bankApplication.Controllers;

import com.bankApplication.services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class BaseController {
    @Autowired
    protected ModelMapper modelMapper;
    @Autowired
    protected AccountService accountService;
}
