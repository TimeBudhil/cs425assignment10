package com.cs425.PatientsAppointmentsBookingApp.service;

import org.springframework.stereotype.Service;

import com.cs425.PatientsAppointmentsBookingApp.models.Patient;
import com.cs425.PatientsAppointmentsBookingApp.repository.PatientRepository;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}