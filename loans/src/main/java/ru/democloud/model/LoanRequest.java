package ru.democloud.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanRequest {
    Integer customerId;
    Integer months;
    Integer amount;
}
