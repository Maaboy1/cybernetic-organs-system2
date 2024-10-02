package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;
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

    //ability to sort by multiple properties in order. name, model, compatibility using built-in sort
    public List<Organ> sortOrganByNameModelAndCompatibilityUsingBuiltInSort() {
        List<Organ> sortedList = new ArrayList<>(inventory);
        Collections.sort(sortedList, (o1, o2) -> {
            int nameCompare = o1.getName().compareTo(o2.getName());
            if (nameCompare != 0) {
                return nameCompare;
            }
            int modelCompare = o1.getModel().compareTo(o2.getModel());
            if (modelCompare != 0) {
                return modelCompare;
            }
            return o1.getCompatibility().compareTo(o2.getCompatibility());
        });
        return sortedList;
    }

    //ability to sort by multiple properties in order. name, model, compatibility using quicksort
    public List<Organ> quickSortOrganByNameModelAndCompatibility(List<Organ> unmodifiableOrganList) {
        List<Organ> modifiableList = new ArrayList<>(unmodifiableOrganList);
        quickSort(modifiableList, 0, modifiableList.size() - 1);
        return modifiableList;
    }

    private void quickSort(List<Organ> organList, int low, int high) {
    if (low < high) {
        int pi = partition(organList, low, high);
        quickSort(organList, low, pi - 1);  // Sort left half
        quickSort(organList, pi + 1, high); // Sort right half
    }
}

    private int partition(List<Organ> organList, int low, int high) {
    Organ pivot = organList.get(high); // Taking the last element as pivot
    int i = low - 1; // Pointer for the greater element

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

    ;
    }

