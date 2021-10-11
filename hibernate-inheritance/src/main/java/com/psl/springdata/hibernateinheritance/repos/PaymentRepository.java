package com.psl.springdata.hibernateinheritance.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psl.springdata.hibernateinheritance.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
