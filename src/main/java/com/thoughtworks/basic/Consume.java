package com.thoughtworks.basic;

import java.math.BigDecimal;

public class Consume {
    private  String normal;
    private  String consumeTime;
    private  String consumeType;
    private  BigDecimal consumeAmout;
    private BigDecimal integral;

    public Consume(String normal, String consumeTime, String consumeType, BigDecimal consumeAmout) {
        this.normal = normal;
        this.consumeTime = consumeTime;
        this.consumeType = consumeType;
        this.consumeAmout = consumeAmout;
        this.integral = new BigDecimal(0);
    }

    public String getNormal() {
        return normal;
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

    public void goldCardIntegral(){
        if ("goldcardUser".equals(this.normal)){
            this.integral=this.integral.add(this.integral.multiply(new BigDecimal(0.5)));
            this.integral = this.integral.setScale(0,BigDecimal.ROUND_DOWN);
        }
    }
}
