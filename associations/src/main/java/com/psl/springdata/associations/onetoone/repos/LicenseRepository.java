package com.psl.springdata.associations.onetoone.repos;

import org.springframework.data.repository.CrudRepository;

import com.psl.springdata.associations.onetoone.entities.License;

public interface LicenseRepository extends CrudRepository<License, Long> {

}
