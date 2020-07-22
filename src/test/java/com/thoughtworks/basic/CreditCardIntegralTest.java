package com.thoughtworks.basic;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class CreditCardIntegralTest {

    @Test
    public void should_return_0_when_given_normal_user_pos_amont_8(){
       //given
        Consume consume = new Consume("normal","2020-07-01 18:40","POS",new BigDecimal(8));
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consume);
        //when
        BigDecimal result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(new BigDecimal(0),result);
    }

    @Test
    public void should_return_10_when_given_normal_user_pos_amont_108(){
        //given
        Consume consume = new Consume("normal","2020-07-01 18:40","POS",new BigDecimal(108));
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consume);
        //when
        BigDecimal result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(new BigDecimal(10),result);
    }
}
