package com.example.demo.lambdasDemo;

import java.util.List;

@FunctionalInterface
public interface PrintableImpl <K, V extends List<?>>{
    V printThing(K k);
    default void showPrintableImpl()
    {
        System.out.println("the default method of printableImple interface");
    }
}
