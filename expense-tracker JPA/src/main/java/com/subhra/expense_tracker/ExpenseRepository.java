package com.subhra.expense_tracker;

import org.springframework.data.jpa.repository.JpaRepository;

// @Repository 
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    
}
