package com.serdarormanli.alchemytec.repository;

import com.serdarormanli.alchemytec.model.Expense;

import org.springframework.data.jpa.repository.JpaRepository;

public interface
ExpenseRepository extends JpaRepository<Expense, Long> {

}
