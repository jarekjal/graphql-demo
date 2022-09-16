package com.jarekjal.graphqldemo.repo;

import com.jarekjal.graphqldemo.domain.bank.BankAccount;
import com.jarekjal.graphqldemo.domain.bank.Currency;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class InMemoryRepository {

    private Map<UUID, BankAccount> bankAccountMap = new HashMap<>();

    @PostConstruct
    private void initDefaultData(){
        UUID uuid1 = UUID.fromString("8cfaad39-af7c-3f32-9944-0243ad7d63e7");
        BankAccount bankAccount1 = BankAccount.builder()
                .id(uuid1)
                .name("Jarek")
                .currency(Currency.USD)
                .build();
        bankAccountMap.put(uuid1, bankAccount1);
        UUID uuid2 = UUID.fromString("6db1b7ec-f093-3665-8297-4b8a02b16b99");
        BankAccount bankAccount2 = BankAccount.builder()
                .id(uuid2)
                .name("Ania")
                .currency(Currency.CHF)
                .build();
        bankAccountMap.put(uuid2, bankAccount2);
    }

    public void upsertBankAccount(BankAccount bankAccount){
        bankAccountMap.put(bankAccount.getId(), bankAccount);
    }

    public BankAccount getBankAccountById(UUID id){
        return bankAccountMap.get(id);
    }

    public Collection<BankAccount> getAllBankAccounts(){
        return bankAccountMap.values();
    }
}
