package com.cybernetic;

public class WaitingList {
    private WaitingListNode head;

    public void addPatient(Patient patient, int priority) {
        WaitingListNode newNode = new WaitingListNode(patient, priority);
        if (head == null || head.getPriority() < priority) {
            newNode.setNext(head);
            head = newNode;
        } else {
            WaitingListNode current = head;
            while (current.getNext() != null && current.getNext().getPriority() >= priority) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }
    public WaitingListNode getHead() {
        return head ;
    }

    public Patient removeHighestPriority() {
        if (head == null) {
            return null;
        }
        Patient patient = head.getPatient();
        head = head.getNext();
        return patient;
    }

    public void updatePriority(String patientId, int newPriority) {
        Patient patient = findPatientById(patientId);
        if (patient != null) {
            removePatient(patientId);
            addPatient(patient, newPriority);
        }
    }

    private Patient findPatientById(String patientId) {
        WaitingListNode current = head;
        while (current != null) {
            if (current.getPatient().getId().equals(patientId)) {
                return current.getPatient();
            }
            current = current.getNext();
        }
        return null; // Patient not found
    }

    public void displayWaitingList() {
        WaitingListNode current = head;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.getPatient().getName() + " (Priority: " + current.getPriority() + ")");
            current = current.getNext();
            position++;
        }
    }

    public int getPosition(String patientId) {
        WaitingListNode current = head;
        int position = 1;
        while (current != null) {
            if (current.getPatient().getId().equals(patientId)) {
                return position;
            }
            current = current.getNext();
            position++;
        }
        return -1; // Patient not found
    }

    public void removePatient(String patientId) {
        if (head == null) return;

        if (head.getPatient().getId().equals(patientId)) {
            head = head.getNext();
            return;
        }

        WaitingListNode current = head;
        while (current.getNext() != null) {
            if (current.getNext().getPatient().getId().equals(patientId)) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }
}


