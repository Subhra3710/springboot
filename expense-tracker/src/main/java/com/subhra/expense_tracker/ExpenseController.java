package com.subhra.expense_tracker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class ExpenseController {
    private final JdbcTemplate jdbcTemplate;
    // public ExpenseController(JdbcTemplate jdbcTemplate){
    //     this.jdbcTemplate = jdbcTemplate;
    // }
    @RequestMapping(value = "/expenses", method = RequestMethod.GET)  
    public List<Expense> getExpenses(){
        String sql  = "SELECT * FROM expenses";
        // List<Expense> expenses = new ArrayList<>();

         jdbcTemplate.query(sql, (ResultSet) -> {
        //     // System.out.println("id id "+ResultSet.getString("id"));
        //     // System.out.println("title is"+ResultSet.getString("title"));
        //     // System.out.println("category is "+ResultSet.getString("category"));

        //     Expense expense = new Expense();
        //     expense.s//etId(ResultSet.getInt("id"));

            var id = ResultSet.getInt("id");
            var title = ResultSet.getString("title");
            var category = ResultSet.getString("category");
            var price= ResultSet.getDouble("price");
            var date = ResultSet.getDate("date").toLocalDate();

           var expense = new Expense(id, title, category, price, date);
            expenses.add (expense);
         });


        // List<Expense> expenses =  jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));
        // return expenses;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));

        }

    }  

