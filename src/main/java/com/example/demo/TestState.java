package com.example.demo;



import org.springframework.data.util.Pair;

import javax.sound.sampled.Port;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestState {

}
enum States{
    OPEN, LOCKED, ERROR
        }
//class Status{
//    void open(){}
//    void locked(int digit){}
//    void error(int digit){}
//}
//digitclass Locked extends Status{
//    public CombinationLock cb;
//    public Locked(CombinationLock cb){
//
//    }
//    @Override
//    void locked(int digit) {
//        cb.status.equals(digit + "") ? cb.status = "open" :
//                cb.status = (new StringBuilder(cb.status).append(digit)).toString();
//    }
//}
//class Error extends Status{
//
//}

class CombinationLock
{
    private int [] combination;
    public String status;
    Map<States, Pair<String, States>> rules =
         new HashMap<States, Pair<String, States>>();

    public CombinationLock(int[] combination)
    {
        this.combination = combination;
        rules.put(States.LOCKED,
               Pair.of(Arrays.toString(combination), States.OPEN));
    }

    public void enterDigit(int digit)
    {
        // todo: check digit and update status here
        status += digit;
// this is the fist code for the decoration
       Pair p =  rules.get(States.LOCKED);
       if (p !=null && p.getSecond().equals(States.OPEN)){
           status = States.OPEN.toString();
       }

    }
}