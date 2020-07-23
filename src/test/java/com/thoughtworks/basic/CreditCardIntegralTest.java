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
        Consume consume = new Consume("normal","2020-07-02 18:50","POS机消费",new BigDecimal(8));
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：0\n" +
                "2020-07-02 18:50 POS机消费 8元，积分 +0";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_10_when_given_normal_user_pos_amont_108(){
        //given
        Consume consume = new Consume("normal","2020-07-02 18:40","POS机消费",new BigDecimal(108));
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：10\n" +
                "2020-07-02 18:40 POS机消费 108元，积分 +10";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_10_when_given_normal_user_pos_amont_208(){
        //given
        Consume consume = new Consume("normal","2020-07-02 18:40","POS机消费",new BigDecimal(208));
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：20\n" +
                "2020-07-02 18:40 POS机消费 208元，积分 +20";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }
}
