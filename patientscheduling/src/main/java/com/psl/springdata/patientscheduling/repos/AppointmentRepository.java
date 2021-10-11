package com.psl.springdata.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.psl.springdata.patientscheduling.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
