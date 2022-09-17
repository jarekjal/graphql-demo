package com.jarekjal.graphqldemo.repo;

import com.jarekjal.graphqldemo.domain.bank.BankAccount;
import com.jarekjal.graphqldemo.domain.bank.Client;
import com.jarekjal.graphqldemo.domain.bank.Currency;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class InMemoryRepository {

    private Map<UUID, BankAccount> bankAccountMap = new HashMap<>();

    @PostConstruct
    @SneakyThrows
    private void initDefaultData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        UUID uuid1 = UUID.fromString("8cfaad39-af7c-3f32-9944-0243ad7d63e7");
        BankAccount bankAccount1 = BankAccount.builder()
                .id(uuid1)
                .client(Client.builder()
                        .firstName("Jarek")
                        .lastName("Jałoszyński")
                        .email("jarekajal@wp.pl")
                        .phone("+48503397737")
                        .dateOfBirth(sdf.parse("1980-04-10"))
                        .build())
                .currency(Currency.USD)
                .build();
        bankAccountMap.put(uuid1, bankAccount1);
        UUID uuid2 = UUID.fromString("6db1b7ec-f093-3665-8297-4b8a02b16b99");
        BankAccount bankAccount2 = BankAccount.builder()
                .id(uuid2)
                .client(Client.builder()
                        .firstName("Anna")
                        .lastName("Giełżecka")
                        .email("biedronka66615@wp.pl")
                        .dateOfBirth(sdf.parse("1983-05-17"))
                        .build())
                .currency(Currency.CHF)
                .build();
        bankAccountMap.put(uuid2, bankAccount2);
    }

    public void upsertBankAccount(BankAccount bankAccount) {
        bankAccountMap.put(bankAccount.getId(), bankAccount);
    }

    public BankAccount getBankAccountById(UUID id) {
        return bankAccountMap.get(id);
    }

    public Collection<BankAccount> getAllBankAccounts() {
        return bankAccountMap.values();
    }
}
