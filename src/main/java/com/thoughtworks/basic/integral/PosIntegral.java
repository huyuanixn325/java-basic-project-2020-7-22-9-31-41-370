package com.thoughtworks.basic.integral;

import com.thoughtworks.basic.Consume;

import java.math.BigDecimal;

public class PosIntegral implements CalculateIntegral {
    @Override
    public void countIntegral(Consume consume) {
        BigDecimal count = consume.getConsumeAmout().divideToIntegralValue(new BigDecimal(10));
        consume.addBigDecimal(count.multiply(new BigDecimal(1)));
    }
}
