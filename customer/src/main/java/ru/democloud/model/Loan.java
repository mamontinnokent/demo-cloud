package ru.democloud.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer loanId;
	Integer customerId;
	Integer totalAmount;
	Integer countMonths;
	Float amountMonthPaid;
	LocalDate createDt;
	
}
