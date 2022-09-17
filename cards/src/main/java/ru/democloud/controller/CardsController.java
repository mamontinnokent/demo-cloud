package ru.democloud.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import ru.democloud.model.Accounts;
import ru.democloud.model.Card;
import ru.democloud.repository.CardsRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CardsController {
	CardsRepository cardsRepository;

	@GetMapping("/myCards/{customerId}")
	public List<Card> getCardsDetails(@PathVariable("customerId") int customerId) {
		var cards = cardsRepository.findByCustomerId(customerId);
		if (cards != null) {
			return cards;
		} else {
			return null;
		}
	}

	@PostMapping("/create")
	public void create(@RequestBody Accounts accounts) {
		cardsRepository.save(
				new Card()
						.setCardNumber(gerCardNbr())
						.setAccountNumber(accounts.getAccountNumber())
						.setCustomerId(accounts.getCustomerId())
						.setAmount(accounts.getAmount())
						.setCreateDt(LocalDate.now())
		);
	}

	private String gerCardNbr() {
		return Stream.generate(() -> (int) (10 * Math.random()))
				.limit(16)
				.map(String::valueOf)
				.collect(Collectors.joining());
	}
}
