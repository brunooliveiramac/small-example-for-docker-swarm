package com.solid.resource;

import com.solid.application.Application;
import com.solid.domain.model.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/budget")
public class BudgetResource {

    @Autowired
    private Application application;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> process(@RequestBody Budget budget) {
        application.processBudget(budget);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
