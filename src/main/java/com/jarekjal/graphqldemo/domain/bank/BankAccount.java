package com.jarekjal.graphqldemo.domain.bank;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Value
@Builder
public class BankAccount {

    UUID id;
    Client client;
    Currency currency;
    LocalDate opened;
}
