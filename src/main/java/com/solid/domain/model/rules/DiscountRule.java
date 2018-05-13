package com.solid.domain.model.rules;

import com.solid.domain.model.Budget;

public interface DiscountRule {

    double discount(Budget budget);

    void next(DiscountRule rule);
}
