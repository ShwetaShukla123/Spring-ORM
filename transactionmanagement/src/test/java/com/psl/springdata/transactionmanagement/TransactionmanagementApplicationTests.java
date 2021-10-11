package com.psl.springdata.transactionmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psl.springdata.transactionmanagement.services.BankAccountService;

@SpringBootTest
class TransactionmanagementApplicationTests {
	
	@Autowired
	BankAccountService service;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testTransfer() {
		service.transferMoney(100);
	}

}
