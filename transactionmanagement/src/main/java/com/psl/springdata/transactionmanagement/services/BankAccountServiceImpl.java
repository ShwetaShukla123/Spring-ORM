package com.psl.springdata.transactionmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psl.springdata.transactionmanagement.entities.Bankaccount;
import com.psl.springdata.transactionmanagement.repos.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	BankAccountRepository repository;

	@Override
	@Transactional
	public void transferMoney(int amount) {
		Bankaccount bankAccount = repository.findById(1).get();
		bankAccount.setBal(bankAccount.getBal()-amount);
		repository.save(bankAccount);
		
		if(true) {
			throw new RuntimeException();
		}
		
		Bankaccount bankAccount2 = repository.findById(2).get();
		bankAccount2.setBal(bankAccount2.getBal() + amount);
		repository.save(bankAccount2);
	}

}