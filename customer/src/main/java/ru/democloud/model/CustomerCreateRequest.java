package ru.democloud.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerCreateRequest {
    String name;
    String city;
    Integer age;
}
