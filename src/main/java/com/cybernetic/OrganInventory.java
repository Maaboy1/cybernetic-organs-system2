package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrganInventory {
    private final List<Organ> inventory;

    public OrganInventory() {
        this.inventory = new ArrayList<>();
    }

    public void addOrgan(Organ organ) {
        inventory.add(organ);
    }

    public List<Organ> getOrganList() {
        return Collections.unmodifiableList(inventory);
    }

    public List<Organ> sortOrganByNameModelAndCompatibilityUsingBuiltInSort() {
        List<Organ> sortedList = new ArrayList<>(inventory); // Create a modifiable copy of the inventory
        Collections.sort(sortedList, new Comparator<Organ>() {
            @Override
            public int compare(Organ o1, Organ o2) {
                int nameCompare = o1.getName().compareTo(o2.getName());
                if (nameCompare != 0) {
                    return nameCompare;
                }
                int modelCompare = o1.getModel().compareTo(o2.getModel());
                if (modelCompare != 0) {
                    return modelCompare;
                }
                return o1.getCompatibility().compareTo(o2.getCompatibility());
            }
        });
        return sortedList;
    }

    public List<Organ> quickSortOrganByNameModelAndCompatibility(List<Organ> unmodifiableOrganList) {
        List<Organ> modifiableList = new ArrayList<>(unmodifiableOrganList); // Create a modifiable copy
        quickSort(modifiableList, 0, modifiableList.size() - 1);
        return modifiableList;
    }

    private void quickSort(List<Organ> organList, int low, int high) {
        if (low < high) {
            int pi = partition(organList, low, high); // Partitioning index
            quickSort(organList, low, pi - 1); // Sort elements before partition
            quickSort(organList, pi + 1, high); // Sort elements after partition
        }
    }

    private int partition(List<Organ> organList, int low, int high) {
        Organ pivot = organList.get(high); // Taking the last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compareOrgan(organList.get(j), pivot) <= 0) {
                i++;
                swap(organList, i, j);
            }
        }
        swap(organList, i + 1, high);
        return i + 1;
    }

    private int compareOrgan(Organ o1, Organ o2) {
        int nameCompare = o1.getName().compareTo(o2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        int modelCompare = o1.getModel().compareTo(o2.getModel());
        if (modelCompare != 0) {
            return modelCompare;
        }
        return o1.getCompatibility().compareTo(o2.getCompatibility());
    }

    private void swap(List<Organ> organList, int i, int j) {
        Organ temp = organList.get(i);
        organList.set(i, organList.get(j));
        organList.set(j, temp);
    }
}
