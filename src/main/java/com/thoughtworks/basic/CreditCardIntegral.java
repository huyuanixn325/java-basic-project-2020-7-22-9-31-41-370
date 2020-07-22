package com.thoughtworks.basic;

import com.thoughtworks.basic.integral.CalculateIntegral;
import com.thoughtworks.basic.integral.PosIntegral;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreditCardIntegral {
    private Consume consume;
    private List<CalculateIntegral> integrals = new ArrayList<>();

    public CreditCardIntegral(Consume consume) {
        this.consume = consume;
        initIntegrals();
    }



    private void initIntegrals(){
        integrals.add(new PosIntegral());
    }

    public BigDecimal countIntegral() {
        BigDecimal integral = new BigDecimal(0);
        for (CalculateIntegral integral1:integrals){
            integral =integral.add(integral1.countIntegral(consume));
        }
        return integral;
    }
}
