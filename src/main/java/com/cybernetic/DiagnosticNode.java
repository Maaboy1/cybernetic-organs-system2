package com.cybernetic;

public class DiagnosticNode {
    String measurementType;
    double thresholdValue;
    String diagnosis;
    DiagnosticNode left;
    DiagnosticNode right;

    public DiagnosticNode(String measurementType, double thresholdValue, String diagnosis) {
        this.measurementType = measurementType;
        this.thresholdValue = thresholdValue;
        this.diagnosis = diagnosis;
        this.left = null;
        this.right = null;
    }
}
