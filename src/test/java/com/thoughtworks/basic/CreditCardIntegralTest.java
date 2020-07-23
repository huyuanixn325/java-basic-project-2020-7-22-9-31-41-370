package com.thoughtworks.basic;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class CreditCardIntegralTest {

    @Test
    public void should_return_0_when_given_normal_user_pos_amont_8(){
       //given
        Consume consume = new Consume("normal","2020-07-01 18:40","POS机消费",new BigDecimal(8));
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        //when
        BigDecimal result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(new BigDecimal(0),result);
    }

    @Test
    public void should_return_10_when_given_normal_user_pos_amont_108(){
        //given
        Consume consume = new Consume("normal","2020-07-01 18:40","POS机消费",new BigDecimal(108));
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        //when
        BigDecimal result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(new BigDecimal(10),result);
    }

    @Test
    public void should_return_10_when_given_normal_user_pos_amont_208(){
        //given
        Consume consume = new Consume("normal","2020-07-01 18:40","POS机消费",new BigDecimal(208));
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        //when
        BigDecimal result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(new BigDecimal(20),result);
    }
}
