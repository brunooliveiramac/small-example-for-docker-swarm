package com.solid.infrastructure.client;

import com.solid.domain.model.Budget;
import org.springframework.stereotype.Component;


@Component
public class AOLClient {
    public void send(Budget budget) {
        System.out.println("Sending...");
    }
}
