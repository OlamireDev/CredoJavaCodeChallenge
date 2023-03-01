package com.olamireDev.credoCodeChallenge.repository;

import com.olamireDev.credoCodeChallenge.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
}
