package ru.democloud.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.democloud.model.Accounts;


@FeignClient("cards")
public interface CardsFeignClient {

	@PostMapping("/create")
	void create(@RequestBody Accounts accounts);
}
