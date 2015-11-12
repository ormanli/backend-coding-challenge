package com.serdarormanli.alchemytec.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/***
 * Database model for expenses. Maps to EXPENSES table.
 */
@Entity
@Table(name = "EXPENSES")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Date expenseDate;
    String reason;
    BigDecimal amount;
    BigDecimal vat;
}
