package com.serdarormanli.alchemytec.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

public class ExpenseData {
    private static final BigDecimal VAT = BigDecimal.valueOf(20L);
    private static final BigDecimal TOTAL = BigDecimal.valueOf(100L).add(VAT);

    private Date expenseDate;
    private String reason;
    private BigDecimal amount;
    private BigDecimal vat;

    public ExpenseData() {
    }

    public ExpenseData(Date expenseDate, String reason, BigDecimal amount, BigDecimal vat) {
        this.expenseDate = expenseDate;
        this.reason = reason;
        this.amount = amount;
        this.vat = vat;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    @JsonIgnore
    public Expense convertToExpense() {
        Expense result = new Expense();

        result.amount = this.amount;
        result.expenseDate = this.expenseDate;
        result.reason = this.reason;
        result.vat = Optional.ofNullable(this.vat).orElse(this.amount.multiply(VAT).divide(TOTAL));//(120*20)/120

        return result;
    }

    @JsonIgnore
    public static ExpenseData convertToThis(Expense expense) {
        return new ExpenseData(expense.expenseDate, expense.reason, expense.amount, expense.vat);
    }
}