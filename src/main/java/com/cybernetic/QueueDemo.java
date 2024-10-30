//package com.cybernetic;
//
//import javax.management.RuntimeErrorException;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static sun.awt.image.MultiResolutionCachedImage.map;
//
//public class QueueDemo {
//
//    public static void main(String[] args) {
//
//        Queue<String> queue = new LinkedList<>();
//
//        queue.add("Jone");
//        queue.add("Marry");
//        queue.add("Peter");
//
//        System.out.println(queue);
//        queue.remove();
//        System.out.println(queue);
//
//        PatientQueue patientQueue = new PatientQueue(10);
//        Patient johnDoe = new Patient("P001", "John Doe", "A+", 70, "HLA-A");
//        Patient janeSmith = new Patient("P002", "Jane Smith", "B-", 65, "HLA-B");
//        Patient bobJohnson = new Patient("P003", "Bob Johnson", "O+", 80, "HLA-A");
//        Patient aliceBrown = new Patient("P004", "Alice Brown", "AB-", 55, "HLA-C");
//
//        patientQueue.enqueue(johnDoe);
//        patientQueue.enqueue(janeSmith);
//        patientQueue.enqueue(bobJohnson);
//
//        System.out.println(patientQueue);
//    }
//}
//
//class PatientQueue{
//    int count;
//    Patient[] patients;
//
//    public PatientQueue(int capacity){
//        patients = new Patient[10];
//    }
//
//    public void enqueue(Patient patient){
//        if(count==patients.length){
//            throw new RuntimeErrorException("Oueue is full") ;
//        }
//        patients[count++] = patient;
//    }
//    public Patient dequeue() {
//        if(isEmpty()){
//            throw new RuntimeErrorException("Queue is Empty");
//        }
//        Patient patients = patients[0];
//        for (int i = 0; i < count; i++){
//            patients[i] = patients[i +1];
//        }
//        patients[count-1]=null;
//        count--;
//        return patients;
//
//        return patients[0];
//    }
//
//    public Patient peek() {
//        return
//
//    }
//    public boolean isEmpty(){
//        return count == 0;
//    }
//
//    @Override
//    public String toString() {
//        Stream.of(patients)
//                .filter(Objects:nonNull)
//                .map(patient  -> patient.getName())
//                .collect(Collectors.joining("<---"));
//    }
//}



