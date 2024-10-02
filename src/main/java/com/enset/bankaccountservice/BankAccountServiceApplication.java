package com.enset.bankaccountservice;

import com.enset.bankaccountservice.dao.entities.BankAccount;
import com.enset.bankaccountservice.dao.entities.Customer;
import com.enset.bankaccountservice.dao.repositories.BankAccountRepository;
import com.enset.bankaccountservice.dao.repositories.CustomerRepository;
import com.enset.bankaccountservice.enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        return args -> {
            Stream.of("Amine", "Mohamed", "Yassine", "Omar", "Hassan").forEach(name -> {
                Customer customer = Customer.builder().name(name).build();
                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(customer -> {
                Stream.of("USD", "EUR", "MAD").forEach(currency -> {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .balance(1000.0 * Math.random() + 1000)
                            .currency(currency)
                            .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVINGS_ACCOUNT)
                            .CreatedAt(new Date())
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankAccount);
                });
            });
        };
    }
}