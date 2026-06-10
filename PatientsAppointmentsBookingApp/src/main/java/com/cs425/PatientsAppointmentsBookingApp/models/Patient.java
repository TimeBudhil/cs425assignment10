package com.cs425.PatientsAppointmentsBookingApp.models;

import java.time.LocalDate;
import java.time.Period;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Patient {
    private long patientID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private MailingAddress mailingAddress;
    private LocalDate dateOfBirth;

    @JsonProperty("age")
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public String toJSON() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules(); // support LocalDate

        try {
            return mapper.writerWithDefaultPrettyPrinter()
                         .writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting Patient to JSON", e);
        }
    }
}
