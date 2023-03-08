package com.example.demo.OpenClosedPrinciple;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class PaymentFactory {
    public static Map<PayType, PaymentInter> paymentMap = new HashMap<>();
    public static PaymentInter getPaymentByUserType(PayType type){
        return paymentMap.get(type);
    }

    public static void register(PayType type, PaymentInter paymentInter){
        Assert.notNull(type,"cannot be null");
        paymentMap.put(type, paymentInter);
    }
}
