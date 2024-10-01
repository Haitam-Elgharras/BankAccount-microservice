package com.enset.bankaccountservice;

import com.enset.bankaccountservice.dao.entities.BankAccount;
import com.enset.bankaccountservice.enums.AccountType;
import com.enset.bankaccountservice.service.dtos.BankAccountRequestDTO;
import com.enset.bankaccountservice.service.services.implementations.BankAccountServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountServiceImpl bankAccountService) {
        return args -> {
            bankAccountService.saveBankAccount(new BankAccountRequestDTO(100.0, "USD", AccountType.CURRENT_ACCOUNT));
            bankAccountService.saveBankAccount(new BankAccountRequestDTO(100.0, "USD", AccountType.CURRENT_ACCOUNT));
            bankAccountService.saveBankAccount(new BankAccountRequestDTO(500.0, "EUR", AccountType.SAVINGS_ACCOUNT));
            bankAccountService.saveBankAccount(new BankAccountRequestDTO(100.0, "USD", AccountType.CURRENT_ACCOUNT));

        };
    }
}
