package com.solid.application;

import com.solid.domain.model.Budget;
import com.solid.domain.service.TransmitService;
import com.solid.infrastructure.client.AOLClient;
import com.solid.infrastructure.repository.BudgetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ApplicationTest {

    @Mock
    private BudgetRepository budgetRepository;

    @Test
    public void JUST_DO_IT() {

        Budget budget = new Budget(1, 600);

        AOLClient client = new AOLClient();
        TransmitService transmitService = new TransmitService(client);
        Application application = new Application(budgetRepository, transmitService);

        when(budgetRepository.save(any())).thenReturn(new Budget(1,600));

        application.processBudget(budget);


        assertEquals(24, budget.discount(), 0.0);

    }


}
