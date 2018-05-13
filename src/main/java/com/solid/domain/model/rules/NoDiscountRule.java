package com.solid.domain.model.rules;

import com.solid.domain.model.Budget;

public class NoDiscountRule implements DiscountRule {


    @Override
    public double discount(Budget budget) {
        return 0;
    }

    @Override
    public void next(DiscountRule rule) {

    }
}
