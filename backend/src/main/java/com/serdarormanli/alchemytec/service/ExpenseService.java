package com.serdarormanli.alchemytec.service;

import com.serdarormanli.alchemytec.model.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> getExpenseList();

    Expense insertNewExpense(Expense newExpense);

    void updateExpense(Expense updatedExpense);

    void deleteExpense(Long id);

    Expense getExpense(Long id);
}