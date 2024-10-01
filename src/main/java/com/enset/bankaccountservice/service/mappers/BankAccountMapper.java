package com.enset.bankaccountservice.service.mappers;

import com.enset.bankaccountservice.dao.entities.BankAccount;
import com.enset.bankaccountservice.service.dtos.BankAccountRequestDTO;
import com.enset.bankaccountservice.service.dtos.BankAccountResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BankAccountMapper {

    public BankAccountResponseDTO toBankAccountResponseDTO(BankAccount bankAccount) {
        return new BankAccountResponseDTO(
                bankAccount.getId(),
                bankAccount.getBalance(),
                bankAccount.getCreatedAt(),
                bankAccount.getCurrency(),
                bankAccount.getType()
        );
    }

    public BankAccount toBankAccount(BankAccountResponseDTO bankAccountResponseDTO) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(bankAccountResponseDTO.getId());
        bankAccount.setBalance(bankAccountResponseDTO.getBalance());
        bankAccount.setCreatedAt(bankAccountResponseDTO.getCreatedAt());
        bankAccount.setCurrency(bankAccountResponseDTO.getCurrency());
        bankAccount.setType(bankAccountResponseDTO.getType());
        return bankAccount;
    }

    public BankAccountRequestDTO toBankAccountRequestDTO(BankAccount bankAccount) {
        return new BankAccountRequestDTO(
                bankAccount.getBalance(),
                bankAccount.getCurrency(),
                bankAccount.getType()
        );
    }

    public BankAccount toBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(bankAccountRequestDTO.getBalance());
        bankAccount.setCreatedAt(new Date());
        bankAccount.setCurrency(bankAccountRequestDTO.getCurrency());
        bankAccount.setType(bankAccountRequestDTO.getType());
        return bankAccount;
    }


}
