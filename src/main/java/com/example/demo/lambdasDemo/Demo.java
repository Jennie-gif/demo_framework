package com.example.demo.lambdasDemo;


import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@ToString
class People{
    private String name;
    private int age;

}

public class Demo {
    public static void testGetPeopleByAge(){
        People p1 = new People("jetty",18);
        People p2 = new People("kitty",12);
        People p3 = new People("Matty",70);
        List<People> list = Arrays.asList(p1,p2,p3);
        getPeopleByAge(71, list);

    }

    public static List<People> getPeopleByAge(int age, List<People> allPeople){
        List<People>  result = null;
        result = applyHigh(age, allPeople, (x, y) -> y.stream()
                .filter(people -> people.getAge() < x)
                .collect(Collectors.toList()) );
        System.out.println(result);
        return  result;
    }

    public static List<People> applyHigh(int age, List<People> originalList,
                                     BiFunction<Integer, List<People>, List<People>> function){
        return  function.apply(age, originalList);
    }




    public static void main(String[] args) {

//        testGetPeopleByAge();
//
//        Printable<String, Integer>  f = k ->  new ArrayList<Integer>() ;
//        ArrayList<Integer> result = f.apply("actual parameter values"); //like f.apply("actual parameter values")
//
//        Function<Integer, String> function = (x) -> {
//            int j = x * 100;
//            return "function get a result  + " + j;
//        };
//        String functionResult = function.apply(100);
//        System.out.println(functionResult);
    }




    static class Compute<V, K>
    {
        /*
        <mappingFunction> define(has confirmed)
         a function , which <?super K> is parameter, and return <? extends V>
         , therefore a function (lambda) who need a parameter which match <? super K>
         */
        public V computeIfAbsent(K key,
                          Function<? super K, ? extends V> mappingFunction) {
            V values = mappingFunction.apply(key);
            return values;
        }

        public void call(K key) {
            // you can see the return result must be <? extends V>
            computeIfAbsent(key, k -> (V) new ArrayList<>());
        }
    }
}
