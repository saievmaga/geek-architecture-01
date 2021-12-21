package com.saiev.composite;
public class Main {
    public static void main(String[] args) {
        FilePackage filePackage = new FilePackage("/home/saiev");
        System.out.println(filePackage.averageSize());
    }
}