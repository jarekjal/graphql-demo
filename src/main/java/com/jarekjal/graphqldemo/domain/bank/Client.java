package com.jarekjal.graphqldemo.domain.bank;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class Client {
    String firstName;
    String lastName;
    Date dateOfBirth;
    String phone;
    String email;
}
