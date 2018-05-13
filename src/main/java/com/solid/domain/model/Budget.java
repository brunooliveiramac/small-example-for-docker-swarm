package com.solid.domain.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solid.domain.model.rules.DiscountRule;
import com.solid.domain.model.rules.DoubleDiscountRule;
import com.solid.domain.model.rules.NoDiscountRule;
import com.solid.domain.model.rules.SimpleDiscountRule;

import javax.persistence.*;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private double discount;

    @Column
    private double value;

    public Budget() {
    }

    public Budget(int id, double value) {
        this.id = id;
        this.value = value;
    }

    public Budget(double value) {
        this.value = value;
    }

    public double value() {
        return value;
    }

    public void makeDiscount() {
        DiscountRule simpleDiscount = new SimpleDiscountRule();
        DiscountRule doubleDiscount = new DoubleDiscountRule();
        DiscountRule noDiscount = new NoDiscountRule();

        simpleDiscount.next(doubleDiscount);
        doubleDiscount.next(noDiscount);

        this.discount = simpleDiscount.discount(this);
    }

    public double discount() {
        return discount;
    }

    public Integer id() {
        return id;
    }
}
