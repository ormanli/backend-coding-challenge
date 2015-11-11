package com.serdarormanli.alchemytec.controller;

import com.serdarormanli.alchemytec.model.BaseExpense;
import com.serdarormanli.alchemytec.model.Expense;
import com.serdarormanli.alchemytec.service.ExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @RequestMapping(value = "/expenses", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseExpense insertNewExpense(@RequestBody BaseExpense requestJson) {
//        Expense expense = new Expense(requestJson);
//
//        expenseService.insertNewExpense(expense);

        return requestJson;
    }

    @RequestMapping(value = "/expenses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BaseExpense> getAllExpenses() {
        return expenseService.getExpenseList().stream().map(Expense::getBase).collect(Collectors.toList());
    }

}