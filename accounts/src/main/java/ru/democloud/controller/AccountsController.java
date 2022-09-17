/**
 * 
 */
package ru.democloud.controller;

import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.web.bind.annotation.*;
import ru.democloud.client.CardsFeignClient;
import ru.democloud.model.*;
import ru.democloud.repository.AccountsRepository;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountsController {
	AccountsRepository accountsRepository;
	CardsFeignClient client;

	@GetMapping("/myAccounts/{customerId}")
	public Accounts getAccountsDetails(@PathVariable("customerId") int customerId) {
		return accountsRepository.findByCustomerId(customerId)
				.orElse(null);
	}

	@KafkaListener(topics = {"loan-kafka-demo"})
	public void loanListener(ConsumerRecord<String, String> record) {
		var value = new Gson().fromJson(record.value(), Loan.class);
		System.out.println();
		System.out.println();
		System.out.println(value);
		System.out.println();
		System.out.println();
		Accounts account = accountsRepository.findByCustomerId(value.getCustomerId())
				.map(accounts -> accountsRepository.save(
						accounts.setAmount(value.getTotalAmount()))
				).orElse(accountsRepository.save(
						new Accounts()
								.setCustomerId(value.getCustomerId())
								.setAmount(value.getTotalAmount())
								.setCreateDt(LocalDate.now())
				));

		client.create(account);
	}
}
