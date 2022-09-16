package com.jarekjal.graphqldemo.resolver;

import com.jarekjal.graphqldemo.domain.bank.BankAccount;
import com.jarekjal.graphqldemo.repo.InMemoryRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    @Autowired
    InMemoryRepository repository;

    public BankAccount bankAccount(UUID id) {
        log.info("Retrieving bank account {}", id);
        return repository.getBankAccountById(id);
    }

    public Collection<BankAccount> allBankAccounts() {
        log.info("Retrieving bank accounts");
        return repository.getAllBankAccounts();
    }

}
