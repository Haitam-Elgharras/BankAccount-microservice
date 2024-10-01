package com.enset.bankaccountservice.dao.entities;

import com.enset.bankaccountservice.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class BankAccount {
    @Id
    private String id;
    private Double balance;
    private Date CreatedAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
