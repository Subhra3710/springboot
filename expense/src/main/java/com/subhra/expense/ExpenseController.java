package com.subhra.expense_tracker;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExpenseController {
    private JdbcTemplate jdbcTemplate;
    public ExpenseController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @RequestMapping(value = "/expenses", method = RequestMethod.GET)  
    public List<String> getExpenses{
        String query = "SELECT" * FROM expenses;

    }  
}
