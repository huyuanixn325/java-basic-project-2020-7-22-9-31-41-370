package com.thoughtworks.basic.integral;

import com.thoughtworks.basic.Consume;

import java.math.BigDecimal;

public class ExpressPaymentIntegral implements CalculateIntegral {
    @Override
    public void countIntegral(Consume consume) {
        if ("快捷支付消费".equals(consume.getConsumeType())) {
            BigDecimal count = consume.getConsumeAmout().divideToIntegralValue(new BigDecimal(10));
            consume.addBigDecimal(count.multiply(new BigDecimal(1)));
            BigDecimal extralCount = consume.getConsumeAmout().divideToIntegralValue(new BigDecimal(100));
            consume.addBigDecimal(extralCount.multiply(new BigDecimal(5)));
        }
    }
}
