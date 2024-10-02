package com.enset.bankaccountservice.dao.entities;

import com.enset.bankaccountservice.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data @Builder
public class BankAccount {
    @Id
    private String id;
    private Double balance;
    private Date CreatedAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @ManyToOne
    private Customer customer;
}
