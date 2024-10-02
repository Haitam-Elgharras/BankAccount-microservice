package com.enset.bankaccountservice.web;

import com.enset.bankaccountservice.dao.entities.BankAccount;
import com.enset.bankaccountservice.dao.entities.Customer;
import com.enset.bankaccountservice.dao.repositories.BankAccountRepository;
import com.enset.bankaccountservice.dao.repositories.CustomerRepository;
import com.enset.bankaccountservice.service.dtos.BankAccountRequestDTO;
import com.enset.bankaccountservice.service.dtos.BankAccountResponseDTO;
import com.enset.bankaccountservice.service.services.interfaces.IBankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BankAccountGraphQLController {
    private final BankAccountRepository accountRepository;
    private final IBankAccountService bankAccountService;
    private final CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountsList() {
        return accountRepository.findAll();
    }

    @QueryMapping
    public BankAccount accountById(@Argument String id) {
        return accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
    }


    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return bankAccountService.saveBankAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount) {
        return bankAccountService.updateBankAccount(id, bankAccount);
    }

    @MutationMapping
    public String deleteAccount(@Argument String id) {
        bankAccountService.deleteBankAccount(id);
        return "Account deleted successfully";
    }

    @QueryMapping
    public List<Customer> customersList() {
        return customerRepository.findAll();
    }
}


