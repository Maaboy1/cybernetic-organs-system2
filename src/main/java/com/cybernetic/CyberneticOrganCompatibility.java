package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CyberneticOrganCompatibility {
    private List<String> incompatibilityReasons;

    public CyberneticOrganCompatibility() {
        this.incompatibilityReasons = new ArrayList<>();
    }

    public boolean isCompatible(Patient patient, CyberneticOrgan organ, DiagnosticDecisionTree diagnosticTree) {
        incompatibilityReasons.clear();
        boolean isCompatible = true;

        Map<String, Double> patientMeasurements = patient.getAllMeasurements();
        Map<String, CyberneticOrgan.Range> organRequirements = organ.getRequirements();

        String diagnosis = diagnosticTree.diagnosePatient(patientMeasurements);
        if ("Not Compatible".equals(diagnosis)) {
            isCompatible = false;
            incompatibilityReasons.add("Diagnostic Tree Result: Not Compatible");
        }

        for (Map.Entry<String, CyberneticOrgan.Range> requirement : organRequirements.entrySet()) {
            String measurementType = requirement.getKey();
            double measurementValue = patientMeasurements.getOrDefault(measurementType, Double.NaN);
            CyberneticOrgan.Range range = requirement.getValue();

            if (measurementValue < range.min || measurementValue > range.max) {
                isCompatible = false;
                incompatibilityReasons.add(measurementType + " out of range: " + measurementValue +
                        " (required: " + range.min + " - " + range.max + ")");
            }
        }

        return isCompatible;
    }

    public List<String> getIncompatibilityReasons() {
        return new ArrayList<>(incompatibilityReasons);
    }
}
