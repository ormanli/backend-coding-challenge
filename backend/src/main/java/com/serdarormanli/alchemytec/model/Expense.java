package com.serdarormanli.alchemytec.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by serdar.ormanli on 11.11.2015.
 */

@Entity
@Table(name = "EXPENSES")
public class Expense extends BaseExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Expense() {
    }

    public Expense(BaseExpense baseExpense) {
        this(null, baseExpense.expenseDate, baseExpense.reason, baseExpense.amount, baseExpense.vat);
    }

    public Expense(Long id, Date expenseDate, String reason, BigDecimal amount, BigDecimal vat) {
        super(expenseDate, reason, amount, vat);
        this.id = id;
    }

    public BaseExpense getBase() {
        return new BaseExpense(this.expenseDate, this.reason, this.amount, this.vat);
    }
}
