package com.example.demo.lambdasDemo;

import java.util.ArrayList;

@FunctionalInterface
public interface Printable<K, V> {

    V apply(K k);
    default void addfunction(String s){
        System.out.println("this is not right");
    }
    boolean equals(Object obj);
    String toString();
}
