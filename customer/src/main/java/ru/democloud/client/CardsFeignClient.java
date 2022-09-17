package ru.democloud.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.democloud.model.Card;
import ru.democloud.model.Customer;

import java.util.List;

@FeignClient("cards")
public interface CardsFeignClient {

	@GetMapping("/myCards/{customerId}")
	List<Card> getCardsDetails(@PathVariable("customerId") int customerId);
}
