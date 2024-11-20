package com.cybernetic;

import java.util.PriorityQueue;

public class EmergencyWaitlist {
    private PriorityQueue<EmergencyCase> priorityQueue;

    public EmergencyWaitlist() {
        this.priorityQueue = new PriorityQueue<>();
    }

    // Add an emergency case
    public void addEmergencyCase(EmergencyCase emergencyCase) {
        priorityQueue.add(emergencyCase);
    }

    // Get the next urgent case
    public EmergencyCase getNextUrgentCase() {
        return priorityQueue.poll();
    }

    // Update case severity
    public void updateCaseSeverity(String caseId, int newLevel) {
        EmergencyCase targetCase = null;
        for (EmergencyCase ec : priorityQueue) {
            if (ec.caseId.equals(caseId)) {
                targetCase = ec;
                break;
            }
        }
        if (targetCase != null) {
            priorityQueue.remove(targetCase);
            targetCase.severityLevel = newLevel;
            priorityQueue.add(targetCase);
        } else {
            throw new IllegalArgumentException("Case not found.");
        }
    }
}
