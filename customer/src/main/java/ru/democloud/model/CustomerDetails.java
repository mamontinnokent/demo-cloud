/**
 * 
 */
package ru.democloud.model;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDetails {
	Customer customer;
	Accounts accounts;
	List<Loan> loans;
	List<Card> cards;
}
