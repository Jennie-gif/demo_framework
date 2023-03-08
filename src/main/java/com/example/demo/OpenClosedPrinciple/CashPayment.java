package com.example.demo.OpenClosedPrinciple;

import org.springframework.stereotype.Component;

@Component
public class CashPayment extends Payment {
    @Override
    public String pay() {
        return "I pay as Cash";
    }

    @Override
    public void setType() {
        this.type = PayType.CASH;
    }
}
