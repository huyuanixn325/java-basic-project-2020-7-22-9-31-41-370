package com.thoughtworks.basic.integral;

import com.thoughtworks.basic.Consume;

import java.math.BigDecimal;

public class WechatIntegral implements CalculateIntegral {
    @Override
    public void countIntegral(Consume consume) {
        if ("微信支付消费".equals(consume.getConsumeType())) {
            BigDecimal count = consume.getConsumeAmout().divideToIntegralValue(new BigDecimal(20));
            consume.addBigDecimal(count.multiply(new BigDecimal(1)));
        }
    }

    @Override
    public void countExtraIntegral(Consume consume) {
        if ("微信支付消费".equals(consume.getConsumeType())&&consume.isGoldcardUser()) {
            BigDecimal count = consume.getConsumeAmout().divideToIntegralValue(new BigDecimal(20));
            consume.addBigDecimal(count.multiply(new BigDecimal(1)).multiply(new BigDecimal(0.5)).setScale(0,BigDecimal.ROUND_DOWN));
        }
    }
}
