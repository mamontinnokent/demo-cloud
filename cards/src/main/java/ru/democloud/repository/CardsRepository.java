package ru.democloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.democloud.model.Card;

import java.util.List;

@Repository
public interface CardsRepository extends CrudRepository<Card, Long> {
	List<Card> findByCustomerId(int customerId);
}
