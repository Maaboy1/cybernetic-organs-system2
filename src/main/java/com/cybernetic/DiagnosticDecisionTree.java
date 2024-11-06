package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DiagnosticDecisionTree {
    private DiagnosticNode root;
    private List<String> diagnosticPath;

    public DiagnosticDecisionTree() {
        this.diagnosticPath = new ArrayList<>();
    }

    public List<String> getDiagnosticPath() {
        return new ArrayList<>(diagnosticPath);  // Return a copy for encapsulation
    }

    // Add a new diagnostic criterion to the tree
    public void addDiagnosticCriteria(String measurementType, double threshold, String diagnosis) {
        DiagnosticNode newNode = new DiagnosticNode(measurementType, threshold, diagnosis);
        if (root == null) {
            root = newNode;
        } else {
            addNode(root, newNode);
        }
    }

    private void addNode(DiagnosticNode current, DiagnosticNode newNode) {
        if (newNode.thresholdValue < current.thresholdValue) {
            if (current.left == null) {
                current.left = newNode;
            } else {
                addNode(current.left, newNode);
            }
        } else {
            if (current.right == null) {
                current.right = newNode;
            } else {
                addNode(current.right, newNode);
            }
        }
    }

    // Diagnose a patient based on their measurements
    public String diagnosePatient(Map<String, Double> measurements) {
        diagnosticPath.clear();  // Clear previous diagnostic path
        return diagnosePatientRecursive(root, measurements, 1);
    }

    private String diagnosePatientRecursive(DiagnosticNode node, Map<String, Double> measurements, int level) {
        if (node == null) return "Inconclusive";

        String measurementType = node.measurementType;
        double measurementValue = measurements.getOrDefault(measurementType, Double.NaN);

        diagnosticPath.add("Level " + level + ": " + measurementType + " = " + measurementValue +
                (measurementValue < node.thresholdValue ? " < " : " ≥ ") + node.thresholdValue);

        if (measurementValue < node.thresholdValue) {
            return node.left == null ? node.diagnosis : diagnosePatientRecursive(node.left, measurements, level + 1);
        } else {
            return node.right == null ? node.diagnosis : diagnosePatientRecursive(node.right, measurements, level + 1);
        }
    }

    public void printTree() {
        System.out.println("\nDiagnostic Tree Structure:");
        printTreeRec(root, "", true);
    }

    private void printTreeRec(DiagnosticNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") +
                    node.measurementType + " (" + node.thresholdValue + ")" +
                    (node.diagnosis != null ? " -> " + node.diagnosis : ""));
            printTreeRec(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTreeRec(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}
