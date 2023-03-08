package com.example.demo.abstractclass;

import java.util.ArrayList;
import java.util.List;

public class AbstractClassTest {
    static public List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        List.copyOf(list);
    }

}