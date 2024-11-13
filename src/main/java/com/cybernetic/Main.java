package com.cybernetic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        OrganInventory inventory = new OrganInventory();
        ArrayList<String> validationErrors = new ArrayList<>();
        ArrayList<Patient> validPatients = new ArrayList<>();

        System.out.println("Part 1 - CyberOrgan Hub Demonstration");
        System.out.println("=====================================\n");

        // 1. Load and validate organs
        System.out.println("1. Loading and Validating Organs...");
        loadOrgans(inventory, validationErrors);

        // Print organ validation errors
        System.out.println("\nOrgan Validation Errors:");
        for (String error : validationErrors) {
            System.out.println(error);
        }

        // 2. Demonstrate sorting
        System.out.println("\n2. Demonstrating Organ Sorting...");

        System.out.println("\nSorted by Power Level:");
        for (CyberneticOrgan organ : inventory.sortByPowerLevel()) {
            System.out.printf("ID: %s, Power Level: %d, Type: %s\n",
                    organ.getId(), organ.getPowerLevel(), organ.getType());
        }

        System.out.println("\nSorted by Manufacture Date:");
        for (CyberneticOrgan organ : inventory.sortByManufactureDate()) {
            System.out.printf("ID: %s, Manufacture Date: %s, Type: %s\n",
                    organ.getId(), organ.getManufactureDate(), organ.getType());
        }

        System.out.println("\nSorted by Compatibility Score:");
        for (CyberneticOrgan organ : inventory.sortByCompatibilityScore()) {
            System.out.printf("ID: %s, Compatibility Score: %.2f, Type: %s\n",
                    organ.getId(), organ.getCompatibilityScore(), organ.getType());
        }

        // 3. Load and validate patients
        System.out.println("\n3. Loading and Validating Patients...");
        loadPatients(validPatients, validationErrors);

        // Print patient validation errors
        System.out.println("\nPatient Validation Errors:");
        for (String error : validationErrors) {
            System.out.println(error);
        }
    }

    private static void loadOrgans(OrganInventory inventory, ArrayList<String> errors) {
        try {
            CyberneticOrgan organ = new CyberneticOrgan("ORG-0001", "HEART", "HEARTX-2020", 85, 0.9,
                    LocalDate.of(2022, 1, 1), "AVAILABLE", "CyberLife Inc.");
            inventory.addOrgan(organ);
            System.out.println("Successfully added: " + organ.getId());
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private static void loadPatients(ArrayList<Patient> patients, ArrayList<String> errors) {
        try {
            Patient patient = new Patient("PAT-0001", "John Doe", 25, "A+", "HEART", 8,
                    LocalDate.of(2023, 5, 1), "WAITING");
            patients.add(patient);
            System.out.println("Successfully added: " + patient.getId());
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }
}