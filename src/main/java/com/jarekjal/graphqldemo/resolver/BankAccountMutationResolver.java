package com.jarekjal.graphqldemo.resolver;

import com.jarekjal.graphqldemo.domain.bank.BankAccount;
import com.jarekjal.graphqldemo.repo.InMemoryRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMutationResolver implements GraphQLMutationResolver {

    @Autowired
    InMemoryRepository repository;

    public BankAccount createBankAccount(BankAccount bankAccount){
        repository.upsertBankAccount(bankAccount);
        return bankAccount;
    }
}
