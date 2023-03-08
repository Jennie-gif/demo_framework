package com.example.demo.OpenClosedPrinciple;

import org.springframework.stereotype.Component;

@Component
public class EPay extends Payment {
    @Override
    public String pay() {
        return "I pay as e_pay";
    }

    @Override
    public void setType() {
        this.type = PayType.E_PAY;
    }
}
