package com.serdarormanli.alchemytec.controller;

import com.serdarormanli.alchemytec.model.Expense;
import com.serdarormanli.alchemytec.model.ExpenseData;
import com.serdarormanli.alchemytec.service.ExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    /**
     * Saves new expense
     */
    @RequestMapping(value = "/expenses", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ExpenseData insertNewExpense(@Valid @RequestBody ExpenseData request) {
        Expense expense = expenseService.insertNewExpense(request.convertToExpense());
        return ExpenseData.convertToThis(expense);
    }

    /**
     * Returns all expenses at database
     */
    @RequestMapping(value = "/expenses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExpenseData> getAllExpenses() {
        //map expenses at database to rest response expenses
        return expenseService.getExpenseList().stream().map(ExpenseData::convertToThis).collect(Collectors.toList());
    }
}