package ru.democloud.model;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long accountNumber;
	Integer customerId;
	Integer amount;
	LocalDate createDt;
	
}
