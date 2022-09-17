package ru.democloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.democloud.model.Accounts;

@FeignClient("accounts")
public interface AccountsFeignClient {
    @GetMapping("/myAccounts/{customerId}")
    Accounts getAccountsDetails(@PathVariable("customerId") int customerId);
}
