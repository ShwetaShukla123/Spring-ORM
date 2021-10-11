package com.psl.springdata.transactionmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.psl.springdata.transactionmanagement.entities.Bankaccount;

public interface BankAccountRepository extends CrudRepository<Bankaccount, Integer> {

}
