package com.cybernetic;

public class OrganCompatibilityAnalyzer {

    public Patient findCompatiblePatient(Organ organ, WaitingList waitingList) {
        WaitingListNode current = waitingList.getHead();
        Patient bestMatch = null;
        double highestScore = 0.0;

        while (current != null) {
            double score = calculateCompatibilityScore(organ, current.getPatient());
            if (score > highestScore) {
                highestScore = score;
                bestMatch = current.getPatient();
            }
            current = current.getNext();
        }

        return bestMatch;
    }

    public double calculateCompatibilityScore(Organ organ, Patient patient) {
        double bloodTypeScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        double weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        double hlaScore = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());

        return (bloodTypeScore * 0.4) + (weightScore * 0.3) + (hlaScore * 0.3);
    }

    private double calculateBloodTypeCompatibility(String donorType, String recipientType) {
        return donorType.equals(recipientType) ? 1.0 : 0.0;
    }

    private double calculateWeightCompatibility(int organWeight, int patientWeight) {
        return organWeight <= patientWeight ? 1.0 : 0.0;
    }

    private double calculateHlaCompatibility(String organHla, String patientHla) {
        return organHla.equals(patientHla) ? 1.0 : 0.0;
    }
}

