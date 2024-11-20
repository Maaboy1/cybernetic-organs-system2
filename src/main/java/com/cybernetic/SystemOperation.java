package com.cybernetic;

import java.time.LocalDateTime;

public class SystemOperation {
    private String operationId; // Private field
    private String operationType;
    private LocalDateTime timestamp;
    private String description;
    private boolean isReversible;

    // Constructor
    public SystemOperation(String operationId, String operationType, String description, boolean isReversible) {
        this.operationId = operationId;
        this.operationType = operationType;
        this.timestamp = LocalDateTime.now();
        this.description = description;
        this.isReversible = isReversible;
    }

    // Getter for operationId
    public String getOperationId() {
        return operationId;
    }

    // Getter for isReversible
    public boolean isReversible() {
        return isReversible;
    }

    @Override
    public String toString() {
        return operationId + ": " + operationType + " (" + description + ")";
    }
}
