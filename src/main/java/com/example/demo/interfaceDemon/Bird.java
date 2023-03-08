package com.example.demo.interfaceDemon;


import java.util.ArrayList;

public class Bird implements FlyAnimal{
    @Override
    public void fly() {
        System.out.println("you can fly");
    }

    @Override
    public ArrayList getResult() {
        return null;
    }

    @Override
    public void walk() {

    }
}
