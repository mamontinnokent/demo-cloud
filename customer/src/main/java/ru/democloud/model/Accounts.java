package ru.democloud.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Accounts {

	@Id
	@Column(name="account_number")
	Long accountNumber;
	Integer customerId;
	String accountType;
	String branchAddress;
	LocalDate createDt;
	
}
