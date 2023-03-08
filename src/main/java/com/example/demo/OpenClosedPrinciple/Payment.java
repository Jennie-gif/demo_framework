package com.example.demo.OpenClosedPrinciple;

import org.springframework.beans.factory.InitializingBean;

public abstract class Payment implements PaymentInter, InitializingBean {
    protected PayType type;

    public abstract void setType();
    @Override
    public void afterPropertiesSet() throws Exception {
       setType();
       PaymentFactory.register(this.type,this);
    }
}
