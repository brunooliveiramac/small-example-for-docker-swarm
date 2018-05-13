package com.solid.infrastructure.repository;

import com.solid.domain.model.Budget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends CrudRepository<Budget, Integer>{
}
