package com.solid.integation;


import com.solid.application.Application;
import com.solid.domain.model.Budget;
import com.solid.domain.service.TransmitService;
import com.solid.infrastructure.client.AOLClient;
import com.solid.infrastructure.repository.BudgetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BudgetIntegration {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BudgetRepository budgetRepository;

    @Test
    public void DO_NOT_DO_IT() {

        AOLClient client = new AOLClient();
        TransmitService transmitService = new TransmitService(client);
        Application application = new Application(budgetRepository, transmitService);
        Budget bud = new Budget(1, 600);

        application.processBudget(bud);

        assertEquals(24, bud.discount(), 0.0);

    }


    @Test
    public void JUST_DO_IT() {

        budgetRepository.save(new Budget(600));

        Budget budget = entityManager.find(Budget.class, 1);

        assertNotNull(budget);

    }

}
