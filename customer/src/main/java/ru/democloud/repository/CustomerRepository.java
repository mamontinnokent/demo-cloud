package ru.democloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.democloud.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
