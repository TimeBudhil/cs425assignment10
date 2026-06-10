package com.cs425.PatientsAppointmentsBookingApp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cs425.PatientsAppointmentsBookingApp.models.Patient;

@Repository
public class PatientRepository {

    
    private final List<Patient> patients = new ArrayList<>();

    public void save(Patient patient) {
        patients.add(patient);
    }

    public List<Patient> findAll() {
        return patients;
    }
}
