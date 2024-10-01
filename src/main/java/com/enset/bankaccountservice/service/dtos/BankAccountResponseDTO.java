package com.enset.bankaccountservice.service.dtos;

import com.enset.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class BankAccountResponseDTO {
    private String id;
    private Double balance;
    private Date CreatedAt;
    private String currency;
    private AccountType type;
}
