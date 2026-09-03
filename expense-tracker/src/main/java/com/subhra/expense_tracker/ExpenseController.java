package com.subhra.expense_tracker;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class ExpenseController {
    private final JdbcTemplate jdbcTemplate;

    private static final String EXPENSES_TABLE = "expenses";

    // public ExpenseController(JdbcTemplate jdbcTemplate){
    //     this.jdbcTemplate = jdbcTemplate;
    // }

    @RequestMapping(value = "/expenses", method = RequestMethod.GET)  

    public List<Expense> getExpenses(){
        String sql  = "SELECT * FROM %s".formatted(EXPENSES_TABLE);
        // List<Expense> expenses = new ArrayList<>();

        //  jdbcTemplate.query(sql, (ResultSet) -> {
        //     // System.out.println("id id "+ResultSet.getString("id"));
        //     // System.out.println("title is"+ResultSet.getString("title"));
        //     // System.out.println("category is "+ResultSet.getString("category"));

        //     Expense expense = new Expense();
        //     expense.s//etId(ResultSet.getInt("id"));

        //     var id = ResultSet.getInt("id");
        //     var title = ResultSet.getString("title");
        //     var category = ResultSet.getString("category");
        //     var price= ResultSet.getDouble("price");
        //     var date = ResultSet.getDate("date").toLocalDate();

        //    var expense = new Expense(id, title, category, price, date);
        //     expenses.add (expense);
        //  });


        // List<Expense> expenses =  jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));
        // return expenses;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));

        }
        @RequestMapping(value= "/expenses/{id}", method = RequestMethod.GET)
        public Expense getExpensById(@PathVariable int id){
           // System.out.println("ID is:" + id);    
           var sql = "SELECT * FROM %s WHERE id=?".formatted(EXPENSES_TABLE);
           Expense expense = jdbcTemplate.queryForObject
                                (sql, new BeanPropertyRowMapper<>(Expense.class), id);
           return expense;
        }
        @RequestMapping(value= "/expenses" , method = RequestMethod.POST)
        public Expense creatExpense(@RequestBody Expense expense){
            var sql = "INSERT INTO %s (title, category, price, date) VALUES(?,?,?,?)"
                                                            .formatted(EXPENSES_TABLE);
            jdbcTemplate.update(sql, expense.getTitle(), expense.getCategory(), 
                                                expense.getPrice(), expense.getDate());
            return expense;
        }
    }  

