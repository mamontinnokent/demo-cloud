/**
 * 
 */
package ru.democloud.controller;


import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import ru.democloud.model.Loan;
import ru.democloud.model.LoanRequest;
import ru.democloud.repository.LoanRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoansController {
	LoanRepository repository;
	KafkaTemplate<String, String> kafkaTemplate;

	@GetMapping("/my-loans/{customerId}")
	public List<Loan> getLoansDetails(@PathVariable("customerId") int customerId) {
		return repository.findAllByCustomerId(customerId);
	}

	@PostMapping("/get-loan")
	public Loan getLoan(@RequestBody LoanRequest request) {
		Loan loan = new Loan()
				.setCustomerId(request.getCustomerId())
				.setTotalAmount(request.getAmount())
				.setAmountMonthPaid((float) request.getAmount() / request.getMonths())
				.setCountMonths(request.getMonths());

		Loan save = repository.save(loan);
		String data = new Gson().toJson(save);
		kafkaTemplate.send("loan-kafka-demo", "loan", data);
		return loan;
	}

}
