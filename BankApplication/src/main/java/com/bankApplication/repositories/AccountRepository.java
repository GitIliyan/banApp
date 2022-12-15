package com.bankApplication.repositories;

import com.bankApplication.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account, Long> {
    Account findByAccountNumberEquals(String accountNumber);
}
