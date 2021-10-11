package com.psl.springdata.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.psl.springdata.patientscheduling.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
