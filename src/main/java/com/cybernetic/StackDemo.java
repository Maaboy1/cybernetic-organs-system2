//package com.cybernetic;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Stack;
//
//public class StackDemo {
//
//    public static void main(String[] args) {
//        StackUsingLinkedList list = new StackUsingLinkedList();
//        Stack<String> stack = new Stack<>();
//
//        stack.push("John");
//        stack.push("Marry");
//        stack.push("Bob");
//
//        System.out.println(stack);
//
//        String item = stack.pop();
//        System.out.println(stack);
//
//        System.out.println(stack.peek());
//        System.out.println(stack);
//    }
//
//
//}
//
//class  StackUsingLinkedList {
//
//    LinkedList<String> list;
//
//    public StackUsingLinkedList() {
//        this.list = new LinkedList<>();
//    }
//
//    public void push(String name) {
//        this.list.push();
//    }
//
//    public void pop() {
//        this.list.pop();
//    }
//    public String peek() {
//        return this.list.peek();
//    }
//    public String toString() {
//        return this.list.toString();
//    }
//}
