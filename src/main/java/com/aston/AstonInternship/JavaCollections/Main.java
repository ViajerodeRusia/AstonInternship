package com.aston.AstonInternship.JavaCollections;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(5);
        myArrayList.add(3);
        System.out.println(myArrayList.toString());
        myArrayList.quicksort();
        System.out.println(myArrayList.toString());
    }
}
