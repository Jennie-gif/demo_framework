package com.example.demo.interfaceDemon;

import java.util.List;
import java.util.function.Function;

public class MultipleInheritance {
    public static void main(String[] args) {

        Animal a = new Bird();
        a.fly();

        FlyAnimal f  = new Bird();
        f.fly();

    }
    public  <V,K> V computeIfAbsent(K key,
                                       Function<? super K, List< ? extends V>> mappingFunction) {
    return null;
    }}
