package com.saiev.proxy;

public class Main {
    public static void main(String[] args) {
        SecuredDoor securedDoor = new SecuredDoor(new LabDoor());
        securedDoor.open("fd");
        securedDoor.open("password");

        securedDoor.close();
    }
}