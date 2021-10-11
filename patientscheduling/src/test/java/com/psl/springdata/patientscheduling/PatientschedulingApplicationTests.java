package com.psl.springdata.patientscheduling;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psl.springdata.patientscheduling.entities.Appointment;
import com.psl.springdata.patientscheduling.entities.Doctor;
import com.psl.springdata.patientscheduling.entities.Insurance;
import com.psl.springdata.patientscheduling.entities.Patient;
import com.psl.springdata.patientscheduling.repos.AppointmentRepository;
import com.psl.springdata.patientscheduling.repos.DoctorRepository;
import com.psl.springdata.patientscheduling.repos.PatientRepository;

@SpringBootTest
class PatientschedulingApplicationTests {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirst_name("Manish");
		doctor.setLast_name("Jha");
		doctor.setSpeciality("All");
		doctorRepository.save(doctor);
	}
	
	@Test
	public void testCreatePatient() {
		Patient patient = new Patient();
		patient.setFirst_name("Doug");
		patient.setLast_name("Bailey");
		patient.setPhone("3244061457");
		
		Insurance insurance = new Insurance();
		insurance.setProviderName("Blue cross blue shield");
		insurance.setCopay(20d);
		patient.setInsurance(insurance);
		
		Doctor doctor = doctorRepository.findById(1L).get();
		
		List<Doctor> doctors = Arrays.asList(doctor);
		patient.setDoctors(doctors);
		
		patientRepository.save(patient);
	}
	
	@Test
	public void testCreateAppointment() {
		Appointment appointment = new Appointment();
		appointment.setAppointmentTime(new Timestamp(new Date().getTime()));
		appointment.setReason("I have a problem");
		appointment.setStarted(true);
		appointment.setPatient(patientRepository.findById(1L).get());
		appointment.setDoctor(doctorRepository.findById(1L).get());
		
		appointmentRepository.save(appointment);
	}

}
