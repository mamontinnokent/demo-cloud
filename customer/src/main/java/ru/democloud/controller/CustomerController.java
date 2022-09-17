package ru.democloud.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import ru.democloud.client.AccountsFeignClient;
import ru.democloud.client.CardsFeignClient;
import ru.democloud.client.LoansFeignClient;
import ru.democloud.model.Accounts;
import ru.democloud.model.Customer;
import ru.democloud.model.CustomerDetails;
import ru.democloud.repository.CustomerRepository;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {
    CustomerRepository repository;

    CardsFeignClient cardsFeignClient;
    LoansFeignClient loansFeignClient;
    AccountsFeignClient accountsFeignClient;

    @PostMapping("/")
    public int create(@RequestBody Customer customer) {
        return repository.save(customer).getId();
    }

    @GetMapping("/{id}")
    public CustomerDetails get(@PathVariable("id") int id) {
        var accountsDetails = accountsFeignClient.getAccountsDetails(id);
        var cards = cardsFeignClient.getCardsDetails(id);
        var loans = loansFeignClient.getLoansDetails(id);

        return new CustomerDetails()
                .setAccounts(accountsDetails)
                .setCards(cards)
                .setLoans(loans);
    }

}
