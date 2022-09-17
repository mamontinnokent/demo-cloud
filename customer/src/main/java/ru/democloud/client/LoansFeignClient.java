package ru.democloud.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.democloud.model.Customer;
import ru.democloud.model.Loan;

import java.util.List;

@FeignClient("loans")
public interface LoansFeignClient {
	@GetMapping("/my-loans/{customerId}")
	List<Loan> getLoansDetails(@PathVariable("customerId")  Integer customerId);
}
