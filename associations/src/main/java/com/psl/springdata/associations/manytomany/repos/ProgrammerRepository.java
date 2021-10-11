package com.psl.springdata.associations.manytomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.psl.springdata.associations.onetomanyentities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
