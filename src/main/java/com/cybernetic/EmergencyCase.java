package com.cybernetic;

import java.time.LocalDateTime;

public class EmergencyCase implements Comparable<EmergencyCase> {
    String caseId;
    Patient patient;
    int severityLevel;
    LocalDateTime registrationTime;

    public EmergencyCase(String caseId, Patient patient, int severityLevel, LocalDateTime registrationTime) {
        this.caseId = caseId;
        this.patient = patient;
        this.severityLevel = severityLevel;
        this.registrationTime = registrationTime;
    }

    @Override
    public int compareTo(EmergencyCase other) {
        if (this.severityLevel != other.severityLevel) {
            return other.severityLevel - this.severityLevel; // Higher severity first
        }
        return this.registrationTime.compareTo(other.registrationTime); // Earlier registration first
    }

    @Override
    public String toString() {
        return caseId + " (Severity: " + severityLevel + ", Wait time: " + registrationTime + ")";
    }
}

