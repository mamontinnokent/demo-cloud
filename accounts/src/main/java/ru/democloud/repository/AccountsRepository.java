package ru.democloud.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.democloud.model.Accounts;

import java.util.Optional;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	Optional<Accounts> findByCustomerId(int customerId);
}
