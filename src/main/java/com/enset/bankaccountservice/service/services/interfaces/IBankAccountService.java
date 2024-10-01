package com.enset.bankaccountservice.service.services.interfaces;

import com.enset.bankaccountservice.dao.entities.BankAccount;
import com.enset.bankaccountservice.service.dtos.BankAccountRequestDTO;
import com.enset.bankaccountservice.service.dtos.BankAccountResponseDTO;

import java.util.List;

public interface IBankAccountService {
    List<BankAccountResponseDTO> getBankAccounts();
    BankAccountResponseDTO getBankAccount(String id);


    BankAccountResponseDTO saveBankAccount(BankAccountRequestDTO bankAccount);

    BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO bankAccount);
    void deleteBankAccount(String id);
}
