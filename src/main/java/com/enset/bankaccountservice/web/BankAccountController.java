package com.enset.bankaccountservice.web;

import com.enset.bankaccountservice.dao.entities.BankAccount;
import com.enset.bankaccountservice.service.dtos.BankAccountRequestDTO;
import com.enset.bankaccountservice.service.dtos.BankAccountResponseDTO;
import com.enset.bankaccountservice.service.services.interfaces.IBankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {
    private final IBankAccountService bankAccountService;

    public BankAccountController(IBankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }


    @GetMapping("/bank-accounts")
    public List<BankAccountResponseDTO> getBankAccounts() {
        return bankAccountService.getBankAccounts();
    }

    @GetMapping("/bank-accounts/{id}")
    public BankAccountResponseDTO getBankAccount(@PathVariable String id) {
        return bankAccountService.getBankAccount(id);
    }

    @PutMapping("/bank-accounts/{id}")
    public BankAccountResponseDTO updateBankAccount(@PathVariable String id,@RequestBody BankAccountRequestDTO bankAccount) {
        return bankAccountService.updateBankAccount(id, bankAccount);
    }

    @PostMapping("/bank-accounts")
    public BankAccountResponseDTO saveBankAccount(@RequestBody BankAccountRequestDTO bankAccount) {
        return bankAccountService.saveBankAccount(bankAccount);
    }

    @DeleteMapping("/bank-accounts/{id}")
    public void deleteBankAccount(@PathVariable String id) {
        bankAccountService.deleteBankAccount(id);
    }


}
