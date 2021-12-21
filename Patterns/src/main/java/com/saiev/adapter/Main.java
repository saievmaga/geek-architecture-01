package com.saiev.adapter;

public class Main {
    public static void main(String[] args) {
        Hunter hunter = new Hunter();
        Lion asianLion = new AsianLion();
        Lion africanLion = new AfricanLion();

        WildDog wildDog = new WildDog();
        WildDogAdapter adapter = new WildDogAdapter(wildDog);


        hunter.hunt(africanLion);
        hunter.hunt(asianLion);

        hunter.hunt(adapter);
    }
}