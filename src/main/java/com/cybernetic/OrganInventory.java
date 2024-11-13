package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrganInventory {
    private ArrayList<CyberneticOrgan> organs;
    private final int maxCapacity = 1000;

    public OrganInventory() {
        this.organs = new ArrayList<>();
    }

    public void addOrgan(CyberneticOrgan organ) {
        if (organs.size() >= maxCapacity)
            throw new IllegalStateException("Inventory is full.");
        for (CyberneticOrgan o : organs) {
            if (o.getId().equals(organ.getId())) throw new IllegalArgumentException("Duplicate organ ID.");
        }
        organs.add(organ);
    }

    public void removeOrgan(String organId) {
        CyberneticOrgan organ = organs.stream()
                .filter(o -> o.getId().equals(organId) && o.getStatus().equals("AVAILABLE"))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Organ cannot be removed."));
        organs.remove(organ);
        System.out.println("Organ " + organId + " removed.");
    }

    public ArrayList<CyberneticOrgan> sortByPowerLevel() {
        ArrayList<CyberneticOrgan> sorted = new ArrayList<>(organs);
        sorted.sort(Comparator.comparingInt(CyberneticOrgan::getPowerLevel).reversed());
        return sorted;
    }

    public ArrayList<CyberneticOrgan> sortByManufactureDate() {
        ArrayList<CyberneticOrgan> sorted = new ArrayList<>(organs);
        sorted.sort(Comparator.comparing(CyberneticOrgan::getManufactureDate).reversed());
        return sorted;
    }

    public ArrayList<CyberneticOrgan> sortByCompatibilityScore() {
        ArrayList<CyberneticOrgan> sorted = new ArrayList<>(organs);
        sorted.sort(Comparator.comparingDouble(CyberneticOrgan::getCompatibilityScore).reversed());
        return sorted;
    }
}

