package com.olamireDev.credoCodeChallenge.repository;

import com.olamireDev.credoCodeChallenge.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
