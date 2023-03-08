package com.example.demo.OpenClosedPrinciple;

import org.springframework.stereotype.Component;

@Component
public class CreditPaymentInter extends Payment {
    @Override
    public String pay() {
        return "I pay as Credit";
    }

    @Override
    public void setType() {
        this.type = PayType.CREDIT;
    }
}
