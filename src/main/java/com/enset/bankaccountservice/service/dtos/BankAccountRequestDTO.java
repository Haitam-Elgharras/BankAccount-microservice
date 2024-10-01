package com.enset.bankaccountservice.service.dtos;

import com.enset.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class BankAccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;
}
