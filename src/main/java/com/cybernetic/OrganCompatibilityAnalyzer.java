package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrganCompatibilityAnalyzer {
    private List<Organ> organs;
    private List<Patient> patients;

    public OrganCompatibilityAnalyzer() {
        organs = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addOrgan(Organ organ) {
        organs.add(organ);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }


    public List<Organ> getCompatibleOrgans(Patient patient) {
        return organs.stream()
                .filter(organ -> isCompatible(organ, patient))
                .collect(Collectors.toList());
    }

    private boolean isCompatible(Organ organ, Patient patient) {
        double bloodTypeScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        double weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        return bloodTypeScore > 0 && weightScore > 0;  // Assuming positive score indicates compatibility
    }

    public Map<Patient, List<Double>> calculateCompatibilityScores() {
        return patients.stream()
                .collect(Collectors.toMap(
                        patient -> patient,
                        patient -> organs.stream()
                                .map(organ -> calculateCompatibilityScore(organ, patient))
                                .collect(Collectors.toList())
                ));
    }

    double calculateCompatibilityScore(Organ organ, Patient patient) {
        double bloodTypeScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        double weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        double hlaScore = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());
        return (bloodTypeScore * 0.4) + (weightScore * 0.3) + (hlaScore * 0.3);
    }

    private double calculateBloodTypeCompatibility(String donorType, String recipientType) {
        // TODO: Implement blood type compatibility logic
        return donorType.equals(recipientType) ? 1.0 : 0.0;
    }

    private double calculateWeightCompatibility(int organWeight, int patientWeight) {
        // TODO: Implement weight compatibility logic
        return (organWeight <= patientWeight) ? 1.0 : 0.0;
    }

    private double calculateHlaCompatibility(String organHla, String patientHla) {
        // TODO: Implement HLA compatibility logic
        return organHla.equals(patientHla) ? 1.0 : 0.0;
    }
}