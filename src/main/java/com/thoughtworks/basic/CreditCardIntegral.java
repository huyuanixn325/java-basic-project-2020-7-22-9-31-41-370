package com.thoughtworks.basic;

import com.thoughtworks.basic.integral.CalculateIntegral;
import com.thoughtworks.basic.integral.PosIntegral;

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
    }

    public BigDecimal countIntegral() {
        BigDecimal integral = new BigDecimal(0);
        for (Consume consume :consumes){
            for (CalculateIntegral integral1:integrals){
                integral1.countIntegral(consume);
                integral =integral.add(consume.getIntegral());
            }
        }
        return integral;
    }
}
