package com.serdarormanli.alchemytec.repository;

/**
 * Created by serdar.ormanli on 11.11.2015.
 */

import com.serdarormanli.alchemytec.model.Expense;

import org.springframework.data.jpa.repository.JpaRepository;

public interface
ExpenseRepository extends JpaRepository<Expense, Long> {

}
