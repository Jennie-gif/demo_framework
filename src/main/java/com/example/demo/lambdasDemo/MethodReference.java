package com.example.demo.lambdasDemo;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class OptUtil{
    static List<String> getSqure(Double x){
        return Arrays.asList(x +"-first", "Gen", "Kency","Zhang");
    }
    public Integer getArea(Integer integer){
        return integer*integer;
    }
}
public class MethodReference {
    static List<String> functionAndSubList(int x,
                                           Function<Double, ? extends List<String>>  function){

        PrintableImpl<Integer, List<String>> ptImpl =
                (PrintableImpl<Integer, List<String>> & Serializable) (c1) -> function.apply(c1.doubleValue()).subList(0, 2);

        return ptImpl.printThing(x);
    }

    <T> List<T>  getObjectList(int length,
                  Supplier<T> objectSupply)
    {
        List<T> list = new ArrayList<>();

        for (int i = 0; i < length; i++)
            list.add(objectSupply.get());
        return list;
    }

    public static void main(String[] args) {
        //Type 1: Reference to a static method
        Function<Double, List<String>> f2 = OptUtil::getSqure;//No ()
        f2.apply(77D).stream().forEach(System.out::println);

        //Type 2: Reference to an instance method of a particular object
        OptUtil optUtil = new OptUtil();
        Function<Integer, Integer> ff = optUtil::getArea;
        System.out.println("ff getArea should be 81 ? " + ff.apply(9));

        //Type 3: Reference to an instance method of an arbitrary object of a particular type
        BiFunction<String, String, Integer> f3 = (s1, s2) -> s1.compareToIgnoreCase(s2);
        f3 = String::compareToIgnoreCase;
        System.out.println("f3 ####" + f3.apply("hi", "HI"));


        //Type 4: Constructor method reference
        Function<Integer, List>  f4 = ArrayList::new;
        Supplier<OptUtil> optUtilSupplier = OptUtil::new;
        OptUtil optUtil1= optUtilSupplier.get();
        System.out.println(optUtil1);


        List<String> result = Arrays.asList("Jon", "Ken");

        // Note that a Lambda is a method, just define a method, but didn't execute it
        Collections.sort(result, (s1, s2) -> s1.compareToIgnoreCase(s2));

        // just same as up code
        // the number and type of parameters should match with the method which use them
        Collections.sort(result, String::compareToIgnoreCase);

        BiFunction<String, String, Integer> f = (s1, s2) -> s1.compareToIgnoreCase(s2);
        f = String::compareToIgnoreCase;
        f = String::indexOf;
        System.out.println("test BiFunction" + f.apply("this", "i"));//should be 2

         Function<String, Integer> fu  = s -> s.length();
         fu  = String::length ;
        System.out.println("test fu " + fu.apply("12345678"));
        /***/



    }

    public void test1(){
    }





    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        /***
         * from the  parameter Function<? super T, ? extends U> keyExtractor
         * we can see, the result of keyExtractor is ? which extends U, and U extends Comparable
         * that means the result of keyExtractor.apply() is ?
         * and which is a Comparable (who has compareTo() method)
         *
         * Furthermore, Comparator, is an FunctionalInterface, which contains
         *  int compare(T o1, T o2);
         * so
         * the whole Lambda can be cast to Comparator
         * (c1, c3 ) ===(o1, o2)
         */

        return (Comparator<T> & Serializable)
                (c1, c3) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c3));
    }

}
