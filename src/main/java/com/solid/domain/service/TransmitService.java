package com.solid.domain.service;

import com.solid.domain.model.Budget;
import com.solid.infrastructure.client.AOLClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransmitService {

    private AOLClient client;

    @Autowired
    public TransmitService(AOLClient client) {
        this.client = client;
    }

    public void send(Budget budget) {
        client.send(budget);
    }
}
