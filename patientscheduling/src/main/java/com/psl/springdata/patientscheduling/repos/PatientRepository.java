package com.psl.springdata.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.psl.springdata.patientscheduling.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
