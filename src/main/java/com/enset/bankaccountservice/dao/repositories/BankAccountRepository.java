package com.enset.bankaccountservice.dao.repositories;

import com.enset.bankaccountservice.dao.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
