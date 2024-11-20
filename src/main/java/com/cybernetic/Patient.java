package com.cybernetic;

import java.time.LocalDate;

public class Patient {
    private String id;
    private String name;
    private int age;
    private String bloodType;
    private String organNeeded;
    private int urgencyLevel;
    private LocalDate registrationDate;
    private String status;

    public Patient(String id, String name, int age, String bloodType, String organNeeded,
                   int urgencyLevel, LocalDate registrationDate, String status) {
        if (!id.matches("PAT-\\d{3,4}")) throw new IllegalArgumentException("Invalid ID format.");
        if (age < 1 || age > 120) throw new IllegalArgumentException("Invalid age.");
        if (!bloodType.matches("A\\+|A-|B\\+|B-|AB\\+|AB-|O\\+|O-")) throw new IllegalArgumentException("Invalid blood type.");
        if (!organNeeded.matches("HEART|LUNG|KIDNEY|LIVER")) throw new IllegalArgumentException("Invalid organ type.");
        if (urgencyLevel < 1 || urgencyLevel > 10) throw new IllegalArgumentException("Urgency level must be 1-10.");
        if (!status.equals("WAITING")) throw new IllegalArgumentException("Status must be WAITING for new patients.");

        this.id = id;
        this.name = name;
        this.age = age;
        this.bloodType = bloodType;
        this.organNeeded = organNeeded;
        this.urgencyLevel = urgencyLevel;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public String getId() { return id; }
    public int getAge() { return age; }

}

