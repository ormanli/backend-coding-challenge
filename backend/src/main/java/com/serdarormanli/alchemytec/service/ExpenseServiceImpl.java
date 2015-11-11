package com.serdarormanli.alchemytec.service;

import com.serdarormanli.alchemytec.model.Expense;
import com.serdarormanli.alchemytec.repository.ExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("expenseServiceImpl")
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getExpenseList() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense insertNewExpense(Expense newExpense) {
        return expenseRepository.save(newExpense);
    }

    @Override
    public void updateExpense(Expense updatedExpense) {
        expenseRepository.save(updatedExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.delete(id);
    }

    @Override
    public Expense getExpense(Long id) {
        return expenseRepository.findOne(id);
    }

}
