package com.example.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

class IntegerPrint {
    public Integer value;
    public void print(){
        System.out.println(value);
    }
}
class StringPrint {
    public String value;
    public void print(){
        System.out.println(value);
    }
}
class Print<T> {
    public T value;
    public Print(T value) {
        this.value = value;
    }
    public void print(T t1){
        System.out.println(value);
        System.out.println(t1);
    }
    public <E> void printAnotherType(E  typeE ){
        System.out.println(typeE);
    }
    public <E> E returnE(E  typeE ){
        System.out.println(typeE);
        return typeE;
    }
    public void printIdonknow(Object Idontknow){
        System.out.println("this is an unsure print" + Idontknow);
    }
    public void printWildcard(List<?> wildCardValue){
        System.out.println("this is a wild card print" + wildCardValue);
    }
}

@ToString(includeFieldNames = true,
        onlyExplicitlyIncluded = true)
class Cat{
    public String name;

    @ToString.Include
    public Integer age;
    @ToString.Exclude
    public String type;
    public Cat(String name) {
        this.name = name;

        this.age = 90;
        this.type="nomalCat";
    }
}


public class GenericTest {
    public static void main(String[] args) {
        Cat mycat = new Cat("ershasha");
        System.out.println( mycat.toString());

       Print p = new Print("ok");
       List list = List.of("string type", 32, mycat);
       p.printWildcard(list);
       p.printIdonknow(list);

       List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Sansha"));
       p.printWildcard(cats);
       p.printIdonknow(cats);

       List<Integer> numbers = new ArrayList<>();
       numbers.add(23);
       p.printWildcard(numbers);
    }
}
