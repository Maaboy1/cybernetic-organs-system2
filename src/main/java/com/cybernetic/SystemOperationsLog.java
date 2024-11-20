package com.cybernetic;

import com.cybernetic.SystemOperation;
import java.util.ArrayList;
import java.util.List;

public class SystemOperationsLog {
    private SystemOperation[] stack;
    private int top;
    private int capacity;

    public SystemOperationsLog(int capacity) {
        this.capacity = capacity;
        this.stack = new SystemOperation[capacity];
        this.top = -1;
    }

    public boolean pushOperation(SystemOperation operation) {
        if (top == capacity - 1) {
            System.out.println("Stack is full. Cannot push.");
            return false;
        }
        stack[++top] = operation;
        return true;
    }

    public SystemOperation popLastOperation() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        return stack[top--];
    }

    public SystemOperation peekLastOperation() {
        if (top == -1) {
            System.out.println("Stack is empty. Nothing to peek.");
            return null;
        }
        return stack[top];
    }

    public List<SystemOperation> getRecentOperations(int count) {
        List<SystemOperation> recentOps = new ArrayList<>();
        for (int i = 0; i < count && top - i >= 0; i++) {
            recentOps.add(stack[top - i]);
        }
        return recentOps;
    }
}