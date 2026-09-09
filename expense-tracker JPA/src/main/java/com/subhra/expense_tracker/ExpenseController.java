package com.subhra.expense_tracker;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor

@RestController
public class ExpenseController{
   
    private final JdbcTemplate jdbcTemplate;
    private static final String EXPENSES_TABLE="expenses";
    private final ExpenseService expenseService;
  
    @GetMapping("/expenses")
    public List<Expense> getExpenses(){

    // String sql ="Select * From %s".formatted(EXPENSES_TABLE);

    //     return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Expense>(Expense.class));
       return expenseService.findAll();  //find all the entity of the table
    
    }

    @GetMapping("/expenses/{id}")

    // }
     
    public Expense getExpensebyId(@PathVariable int id){ 

    //     var sql ="Select * from %s where id=?".formatted(EXPENSES_TABLE);
    //     Expense expense=jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Expense.class),id);
    //    return expense;

    //    Optional<Expense> optExp = expenseService.findById(id);
    // //    Expense expense = optExp.orElseThrow();
    //     Expense expense = optExp.orElseThrow(() -> new RuntimeException("Unable to fimd Expense with id:-"+id));
    //    return expense;

    return expenseService.findById(id)
        .orElseThrow(() -> new RuntimeException(
                "Unable to find Expense with id: " + id
        ));
    }  

    
    @PostMapping("/expenses")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Expense createExpense(@RequestBody Expense expense){
        
    //     var sql="insert into %s (title,category,price,date) values (?,?,?,?)".formatted(EXPENSES_TABLE);

    //     jdbcTemplate.update(sql, expense.getTitle(),expense.getCategory(),expense.getPrice(),expense.getDate());
    //     return expense;
        return expenseService.save(expense);
    }


    @DeleteMapping("/expenses/{id}")        
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable int id){
        // String sql="Delete From %s where id=?".formatted(EXPENSES_TABLE);
        // jdbcTemplate.update(sql,id);
        
        // Expense toBeDeletedExpense = expenseService.deleteById(id);
        // expenseService.delete(toBeDeletedExpense);

        getExpensebyId(id);
        expenseService.deleteById(id);
    }

    @PutMapping("/expenses")
    @ResponseStatus (HttpStatus.ACCEPTED)
    public Expense updateExpense(@RequestBody Expense expense){
        // var sql="Update %s set title=?,category=?,price=?,date=? where id=?".formatted(EXPENSES_TABLE);
        // jdbcTemplate.update(sql,expense.getTitle(),expense.getCategory(),expense.getPrice(),expense.getDate(),expense.getId());
        // return getExpensebyId(expense.getId());

        getExpensebyId(expense.getId());
        return expenseService.save(expense);
    }


}



// JPA:=> Hibernate => ORM object

// =>create a entity class
// => inherit from Repository