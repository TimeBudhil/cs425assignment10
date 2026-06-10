package com.cs425.PatientsAppointmentsBookingApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailingAddress {
    private String streetAddress;
    private String zip;
    private String state;
    private String country;
    
}
