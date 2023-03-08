package com.example.demo.interfaceDemon;

import java.util.ArrayList;
import java.util.List;

public interface FlyAnimal<T, V> extends Animal {
    void fly();
    ArrayList<T> getResult();
     V getRestult (List<? extends T> aa);
}
