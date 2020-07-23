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

    @Test
    public void should_return_30_when_given_normal_user_pos_amont_8_108_208(){
        //given
        Consume consumeA = new Consume("normal","2020-07-02 18:50","POS机消费",new BigDecimal(8));
        Consume consume = new Consume("normal","2020-07-02 18:40","POS机消费",new BigDecimal(108));
        Consume consumeB = new Consume("normal","2020-07-02 18:40","POS机消费",new BigDecimal(208));
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consumeA);
        consumes.add(consume);
        consumes.add(consumeB);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：30\n" +
                "2020-07-02 18:50 POS机消费 8元，积分 +0\n"+
                "2020-07-02 18:40 POS机消费 108元，积分 +10\n"+
                "2020-07-02 18:40 POS机消费 208元，积分 +20";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_1_when_given_normal_user_pos_amont_25(){
        //given
        Consume consume = new Consume("normal","2020-07-02 08:20","微信支付消费",new BigDecimal(25));
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：1\n" +
                "2020-07-02 08:20 微信支付消费 25元，积分 +1";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_1_when_given_normal_user_pos_amont_25_10(){
        //given
        Consume consume = new Consume("normal","2020-07-02 08:20","微信支付消费",new BigDecimal(25));
        Consume consumeA = new Consume("normal","2020-07-02 08:35","微信支付消费",new BigDecimal(10));

        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        consumes.add(consumeA);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：1\n" +
                "2020-07-02 08:20 微信支付消费 25元，积分 +1\n"+
                "2020-07-02 08:35 微信支付消费 10元，积分 +0";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }
}
