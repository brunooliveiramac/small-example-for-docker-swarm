package com.solid.domain.rules;

import com.solid.domain.model.Budget;
import com.solid.domain.model.rules.DiscountRule;
import com.solid.domain.model.rules.SimpleDiscountRule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleDiscountRuleTest {


    @Test
    public void SIMPLE_RULE_SCENARIO_01() {

        Budget budget = new Budget(0);

        DiscountRule discountRule = new SimpleDiscountRule();
        double discount = discountRule.discount(budget);

        assertEquals(0.0, discount, 0.0);
    }

    @Test
    public void SIMPLE_RULE_SCENARIO_02() {

        Budget budget = new Budget(499);

        DiscountRule discountRule = new SimpleDiscountRule();
        double discount = discountRule.discount(budget);

        assertEquals(9.98, discount, 0.0);
    }

}
