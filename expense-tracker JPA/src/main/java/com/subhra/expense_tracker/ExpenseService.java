package com.subhra.expense_tracker;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    // Constructor
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Get all expenses
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    // Get expense by ID
    public Expense getExpenseById(int id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Unable to find Expense with id: " + id));
    }

    // Add expense
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Delete expense
    public void deleteExpenseId(int id) {
        getExpenseById(id);
        expenseRepository.deleteById(id);
    }

    // Update expense
    public Expense updateExpense(Expense expense) {
        getExpenseById(expense.getId());
        return expenseRepository.save(expense);
    }
}