package com.enset.bankaccountservice.web;

import com.enset.bankaccountservice.dao.entities.BankAccount;
import com.enset.bankaccountservice.dao.repositories.BankAccountRepository;
import com.enset.bankaccountservice.service.dtos.BankAccountRequestDTO;
import com.enset.bankaccountservice.service.dtos.BankAccountResponseDTO;
import com.enset.bankaccountservice.service.services.interfaces.IBankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BankAccountGraphQLController {
    private final BankAccountRepository accountRepo;
    private final IBankAccountService bankAccountService;

    @QueryMapping
    public List<BankAccount> accountsList() {
        return accountRepo.findAll();
    }

    @QueryMapping
    public BankAccount accountById(@Argument String id) {
        return accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
    }


    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return bankAccountService.saveBankAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount) {
        return bankAccountService.updateBankAccount(id, bankAccount);
    }

    @MutationMapping
    public String deleteAccount(@Argument String id) {
        bankAccountService.deleteBankAccount(id);
        return "Account deleted successfully";
    }
}

/*
    * The GraphQL controller is a Spring MVC controller that is responsible for handling GraphQL queries and mutations.
    * To make a graphQL request: go to http://localhost:8081/graphiql for example and write the following query:
    query {
  accountById(id:"8bdb25bd-2651-4cf0-b241-c3d9b8a580cf"){
    balance,
    id
  }
}
 or
 query {
  accountsList{
    balance,
    id
  }
  *
  * Note that we can specify the fields we want to retrieve.

 * To make a mutation request, write the following query:
 mutation {
  addAccount(bankAccount:{
    balance: 400,
    currency: "EUR",
    type: "SAVINGS_ACCOUNT"
  }){
    balance,
    id
  }
}
* To write a parameterized mutation request, write the following query:
mutation addAccount($balance: Float, $currency: String, $type: String){
  addAccount(bankAccount:{
    balance: $balance,
    currency: $currency,
    type: $type
  }){
    balance,
    id
  }
 */
