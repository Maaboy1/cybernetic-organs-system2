package com.cybernetic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransplantHistory {
    private TransplantRecord head;

    public TransplantHistory() {
        this.head = null;
    }

    // Add a transplant record at the beginning
    public void addTransplantRecordAtBeginning(TransplantRecord record) {
        record.next = head;
        head = record;
    }

    // Find transplant records by patient ID
    public List<TransplantRecord> findTransplantByPatient(String patientId) {
        List<TransplantRecord> records = new ArrayList<>();
        TransplantRecord current = head;
        while (current != null) {
            if (current.patientId.equals(patientId)) {
                records.add(current);
            }
            current = current.next;
        }
        return records;
    }

    // Get recent transplants
    public List<TransplantRecord> getRecentTransplants(int count) {
        List<TransplantRecord> records = new ArrayList<>();
        TransplantRecord current = head;
        while (current != null && count > 0) {
            records.add(current);
            current = current.next;
            count--;
        }
        return records;
    }

    // Get all transplants by date
    public List<TransplantRecord> getAllTransplantsByDate(LocalDate date) {
        List<TransplantRecord> records = new ArrayList<>();
        TransplantRecord current = head;
        while (current != null) {
            if (current.timestamp.toLocalDate().equals(date)) {
                records.add(current);
            }
            current = current.next;
        }
        return records;
    }
}
