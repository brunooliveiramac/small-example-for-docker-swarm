package com.solid.domain.model.rules;

import com.solid.domain.model.Budget;

public class DoubleDiscountRule implements DiscountRule {

    private DiscountRule nextRule;

    @Override
    public double discount(Budget budget) {
        if (budget.value() > 500) {
            return budget.value() * 0.04;
        }
        return nextRule.discount(budget);
    }

    @Override
    public void next(DiscountRule rule) {
        this.nextRule = rule;
    }
}
