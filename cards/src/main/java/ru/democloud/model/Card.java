package ru.democloud.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cardId;
	long accountNumber;
	int customerId;
	String cardNumber;
	int amount;
	LocalDate createDt;
}
