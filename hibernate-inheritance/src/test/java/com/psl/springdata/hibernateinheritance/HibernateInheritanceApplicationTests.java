package com.psl.springdata.hibernateinheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psl.springdata.hibernateinheritance.entities.Check;
import com.psl.springdata.hibernateinheritance.entities.CreditCard;
import com.psl.springdata.hibernateinheritance.repos.PaymentRepository;

@SpringBootTest
class HibernateInheritanceApplicationTests {
	
	@Autowired
	PaymentRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreatePayment() {
		CreditCard cc= new CreditCard();
		cc.setId(11);
		cc.setAmount(1000);
		cc.setCardnumber("21415345");
		repository.save(cc);
	}
	
	@Test
	public void testCreateCheckPayment() {
		Check ch = new Check();
		ch.setId(12);
		ch.setAmount(1200);
		ch.setChecknumber("12749147");
		repository.save(ch);
	}
}