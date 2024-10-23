package com.cybernetic;

public class Main {
    public static void main(String[] args) {
        WaitingList waitingList = new WaitingList();

        Patient johnDoe = new Patient("P001", "John Doe", "A+", 70, "HLA-A");
        Patient janeSmith = new Patient("P002", "Jane Smith", "B-", 65, "HLA-B");
        Patient bobJohnson = new Patient("P003", "Bob Johnson", "O+", 80, "HLA-A");
        Patient aliceBrown = new Patient("P004", "Alice Brown", "AB-", 55, "HLA-C");

        System.out.println("Adding patients to the waiting list...");
        waitingList.addPatient(johnDoe, 5);
        waitingList.addPatient(janeSmith, 3);
        waitingList.addPatient(bobJohnson, 4);

        System.out.println("\nInitial Waiting List:");
        waitingList.displayWaitingList();

        System.out.println("\nAdding new patient: Alice Brown (Priority: 6)");
        waitingList.addPatient(aliceBrown, 6);

        System.out.println("Updated Waiting List:");
        waitingList.displayWaitingList();

        Patient removedPatient = waitingList.removeHighestPriority();
        System.out.println("\nRemoving highest priority patient: " + removedPatient.getName());

        System.out.println("\nUpdating priority for Bob Johnson to 7");
        waitingList.updatePriority("P003", 7);

        System.out.println("Updated Waiting List:");
        waitingList.displayWaitingList();

        Organ cyberHeart = new Organ("O001", "CyberHeart-X1", "A+", 350, "HLA-A");

        OrganCompatibilityAnalyzer analyzer = new OrganCompatibilityAnalyzer();

        System.out.println("\nMatching " + cyberHeart.getName() + " to Waiting List:");
        Patient matchedPatient = analyzer.findCompatiblePatient(cyberHeart, waitingList);
        if (matchedPatient != null) {
            int priority = waitingList.getPosition(matchedPatient.getId());
            System.out.println("Compatible patient found: " + matchedPatient.getName() +
                    " (Priority: " + priority + ")");
        } else {
            System.out.println("No compatible patient found in the waiting list.");
        }

        System.out.println("\nRemoving matched patient from the waiting list...");
        waitingList.removePatient(matchedPatient.getId());
        System.out.println("Updated Waiting List:");
        waitingList.displayWaitingList();
    }
}
