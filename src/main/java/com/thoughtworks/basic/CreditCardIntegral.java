package com.thoughtworks.basic;

import com.thoughtworks.basic.integral.CalculateIntegral;
import com.thoughtworks.basic.integral.ExpressPaymentIntegral;
import com.thoughtworks.basic.integral.PosIntegral;
import com.thoughtworks.basic.integral.WechatIntegral;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreditCardIntegral {
    private List<Consume> consumes;
    private List<CalculateIntegral> integrals = new ArrayList<>();

    public CreditCardIntegral(List<Consume> consumes) {
        this.consumes = consumes;
        initIntegrals();
    }



    private void initIntegrals(){
        integrals.add(new PosIntegral());
        integrals.add(new WechatIntegral());
        integrals.add(new ExpressPaymentIntegral());
    }

    public String countIntegral() {
        String resultAmount = "总积分：";
        String resultContent = "";
        BigDecimal integral = new BigDecimal(0);
        for (Consume consume :consumes){
            for (CalculateIntegral integral1:integrals){
                integral1.countIntegral(consume);
            }
            integral =integral.add(consume.getIntegral());
            resultContent = resultContent+"\n"+consume.getConsumeTime()+" "+consume.getConsumeType()+" "+consume.getConsumeAmout()+"元，"+"积分 +"+consume.getIntegral();
        }
        resultAmount = resultAmount+integral+resultContent;
        return resultAmount;
    }

}
