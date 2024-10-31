package com.cybernetic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Adding organs to inventory...");

        List<Organ> organs = buildOrganInventory();
        OrganInventory inventory = new OrganInventory();
        for (Organ organ : organs) {
            inventory.addOrgan(organ);
        }

        System.out.println("Sorting inventory by name, model, and compatibility...Using Collection.sort");
        long startTime = System.nanoTime();
        List<Organ> sortedOrgans = inventory.sortOrganByNameModelAndCompatibilityUsingBuiltInSort();
        System.out.println("Time taken to sort using collection.sort: " + (System.nanoTime() - startTime) + "ns");

        System.out.println("Sorting inventory by name, model, and compatibility...Using QuickSort");
        startTime = System.nanoTime();
        sortedOrgans = inventory.quickSortOrganByNameModelAndCompatibility(inventory.getOrganList());
        System.out.println("Time taken to sort using quicksort: " + (System.nanoTime() - startTime) + "ns");
        writeOrganInventory(sortedOrgans);

        System.out.println("Sorted inventory written to file.");


    }

    private static void writeOrganInventory(List<Organ> sortedOrgans) {
        String csvFile = "src/main/resources/sorted-organ-list.csv";
        try (PrintWriter writer = new PrintWriter(csvFile)) {
            writer.write("Model,Name,Functionality,Compatibility\n");
            for (Organ organ : sortedOrgans) {
                writer.write(organ.getName() + "," + organ.getModel() + "," + organ.getFunctionality() + "," + organ.getCompatibility() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<Organ> buildOrganInventory() {
        String csvFile = "src/main/resources/sample-organ-list.csv";
        String line;
        String cvsSplitBy = ",";
        List<Organ> inventory = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] organ= line.split(cvsSplitBy);
                Organ newOrgan = new Organ( organ[1].trim(),organ[0].trim(), organ[2].trim(),organ[3].trim());
                inventory.add(newOrgan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }
}