package com.aleks.testDataSource;

import com.aleks.testDataSource.admissions.models.Admission;
import com.aleks.testDataSource.admissions.repositories.AdmissionRepository;
import com.aleks.testDataSource.appointments.models.Appointment;
import com.aleks.testDataSource.appointments.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
public class TestDataSourceApplication {

	@Autowired
	private AdmissionRepository admissionRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	//Add appointment data
	@PostConstruct
	public void addAppointmentsData(){
		appointmentRepository.saveAll(Stream.of(
				new Appointment(101, "The first appointment"),
				new Appointment(102, "Appointment with dentist"))
				.collect(Collectors.toList()));
	}
	@GetMapping("/getAppointments")
	public List<Appointment> getAppointments(){
		return appointmentRepository.findAll();
	}

	//Add admission data
	@PostConstruct
	public void addAdmissionsData(){
		admissionRepository.saveAll(Stream.of(
				new Admission(101, "The first Admission"),
				new Admission(102, "Admission with dentist"))
				.collect(Collectors.toList()));
	}

	@GetMapping("/getAdmissions")
	public List<Admission> getAdmissions(){
		return admissionRepository.findAll();
	}
	public static void main(String[] args) {
		SpringApplication.run(TestDataSourceApplication.class, args);
	}

}
