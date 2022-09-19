package com.jarekjal.graphqldemo.resolver;

import com.jarekjal.graphqldemo.domain.bank.BankAccount;
import com.jarekjal.graphqldemo.domain.bank.Client;
import com.jarekjal.graphqldemo.repo.InMemoryRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    @Autowired
    InMemoryRepository repository;

    public Client client(BankAccount inputBankAccount){
        var bankAccount = repository.getBankAccountById(inputBankAccount.getId());
        return bankAccount.getClient();
    }
}
