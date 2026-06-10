package com.cs425.PatientsAppointmentsBookingApp;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cs425.PatientsAppointmentsBookingApp.models.MailingAddress;
import com.cs425.PatientsAppointmentsBookingApp.models.Patient;
import com.cs425.PatientsAppointmentsBookingApp.service.PatientService;


	@SpringBootApplication
public class PatientsAppointmentsBookingAppApplication
        implements CommandLineRunner {

    private final PatientService patientService;

    public PatientsAppointmentsBookingAppApplication(
            PatientService patientService) {
        this.patientService = patientService;
    }

    public static void main(String[] args) {
        SpringApplication.run(
                PatientsAppointmentsBookingAppApplication.class,
                args);
    }

    
    @Override
    public void run(String... args) {

        Patient[] patients = {
            new Patient(
				1, 
                "Daniel",
                "Agar",
                "(641) 123-0009",
                "dagar@m.as",
                new MailingAddress("1 N Street", "", "", ""),
                LocalDate.of(1987, 1, 19)
            ),

            new Patient(
				2, 
                "Ana",
                "Smith",
                "",
                "amsith@te.edu",
                new MailingAddress("", "", "", ""),
                LocalDate.of(1948, 12, 5)
            ),

            new Patient(
				3, 
                "Marcus",
                "Garvey",
                "(123) 292-0018",
                "",
                new MailingAddress("4 East Ave", "", "", ""),
                LocalDate.of(2001, 9, 18)
            ),

            new Patient(
				4, 
                "Jeff",
                "Goldbloom",
                "(999) 165-1192",
                "jgold@es.co.za",
                new MailingAddress("", "", "", ""),
                LocalDate.of(1995, 2, 28)
            ),

            new Patient(
				5, 
                "Mary",
                "Washington",
                "",
                "",
                new MailingAddress("30 W Burlington", "", "", ""),
                LocalDate.of(1932, 5, 31)
            )
        };

        // Save patients
        for (Patient patient : patients) {
            patientService.addPatient(patient);
        }

        // Display all patients
        System.out.println("List of Patients:");
        patientService.getAllPatients()
                .forEach(System.out::println);
    }

}
