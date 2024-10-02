package com.enset.bankaccountservice.service.services.implementations;

import com.enset.bankaccountservice.dao.entities.BankAccount;
import com.enset.bankaccountservice.dao.repositories.BankAccountRepository;
import com.enset.bankaccountservice.service.dtos.BankAccountRequestDTO;
import com.enset.bankaccountservice.service.dtos.BankAccountResponseDTO;
import com.enset.bankaccountservice.service.mappers.BankAccountMapper;
import com.enset.bankaccountservice.service.services.interfaces.IBankAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BankAccountServiceImpl implements IBankAccountService {


    private final BankAccountMapper bankAccountMapper;
    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, BankAccountMapper bankAccountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
    }

    @Override
    public List<BankAccountResponseDTO> getBankAccounts() {
        return bankAccountRepository.findAll().stream().map(bankAccountMapper::toBankAccountResponseDTO).toList();
    }

    @Override
    public BankAccountResponseDTO getBankAccount(String id) {
        return bankAccountRepository.findById(id).map(bankAccountMapper::toBankAccountResponseDTO).orElse(null);
    }

    @Override
    public BankAccountResponseDTO saveBankAccount(BankAccountRequestDTO bankAccount) {
        BankAccount account = bankAccountMapper.toBankAccount(bankAccount);
        account.setId(UUID.randomUUID().toString());
        return bankAccountMapper.toBankAccountResponseDTO(bankAccountRepository.save(account));
    }

    @Override
    public BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO bankAccount) {
        BankAccount account = bankAccountRepository.findById(id).orElse(null);
        if (account != null) {
            if (bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
            if (bankAccount.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());
            if (bankAccount.getType() != null) account.setType(bankAccount.getType());
            return bankAccountMapper.toBankAccountResponseDTO(bankAccountRepository.save(account));
        }
        return null;
    }

    @Override
    public void deleteBankAccount(String id) {
        if (bankAccountRepository.existsById(id)) {
            bankAccountRepository.deleteById(id);
            return;
        }

        throw new RuntimeException("Account not found");
    }
}
