package com.thoughtworks.basic;

import java.math.BigDecimal;

public class Consume {
    private  String cardType;
    private  String consumeTime;
    private  String consumeType;
    private  BigDecimal consumeAmout;
    private BigDecimal integral;

    public Consume(String cardType, String consumeTime, String consumeType, BigDecimal consumeAmout) {
        this.cardType = cardType;
        this.consumeTime = consumeTime;
        this.consumeType = consumeType;
        this.consumeAmout = consumeAmout;
        this.integral = new BigDecimal(0);
    }

    public String getNormal() {
        return cardType;
    }

    public String getConsumeTime() {
        return consumeTime;
    }

    public String getConsumeType() {
        return consumeType;
    }

    public BigDecimal getConsumeAmout() {
        return consumeAmout;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void addBigDecimal(BigDecimal integral) {
        this.integral = this.integral.add(integral);
    }

    public Boolean isGoldcardUser(){
        return  ("goldcardUser".equals(this.cardType));
    }
}
