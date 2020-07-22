package com.thoughtworks.basic;

import java.math.BigDecimal;

public class Consume {
    private final String normal;
    private final String consumeTime;
    private final String consumeType;
    private final BigDecimal consumeAmout;

    public Consume(String normal, String consumeTime, String consumeType, BigDecimal consumeAmout) {
        this.normal = normal;
        this.consumeTime = consumeTime;
        this.consumeType = consumeType;
        this.consumeAmout = consumeAmout;
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
}
