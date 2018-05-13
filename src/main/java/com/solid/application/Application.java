package com.solid.application;

import com.solid.domain.model.Budget;
import com.solid.domain.service.TransmitService;
import com.solid.infrastructure.repository.BudgetRepository;
import org.springframework.stereotype.Component;

@Component
public class Application {

    private BudgetRepository repository;
    private TransmitService transmitter;

    public Application(BudgetRepository repository, TransmitService transmitter) {
        this.repository = repository;
        this.transmitter = transmitter;
    }


    public void processBudget(Budget budget) {
        budget.makeDiscount();
        System.out.println("Discount: " + budget.discount());
        transmitter.send(budget);
        repository.save(budget);
    }

}
