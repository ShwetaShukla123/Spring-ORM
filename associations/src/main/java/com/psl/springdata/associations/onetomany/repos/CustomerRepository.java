package com.psl.springdata.associations.onetomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.psl.springdata.associations.onetomanyentities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
