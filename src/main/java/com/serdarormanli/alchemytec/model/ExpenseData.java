package com.serdarormanli.alchemytec.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.Optional;

import javax.validation.constraints.NotNull;

/***
 * Rest input output class
 */
public class ExpenseData {
    private static final BigDecimal VAT = BigDecimal.valueOf(20L);
    private static final BigDecimal TOTAL = BigDecimal.valueOf(100L).add(VAT);

    @NotNull(message = "Date cannot be null")
    private Date date;
    @NotNull(message = "Reason cannot be null")
    private String reason;
    @NotNull(message = "Amount cannot be null")
    private BigDecimal amount;
    private BigDecimal vat;

    public ExpenseData() {
    }

    public ExpenseData(Date date, String reason, BigDecimal amount, BigDecimal vat) {
        this.date = date;
        this.reason = reason;
        this.amount = amount;
        this.vat = vat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    /**
     * Converts from rest expense to database expense
     */
    @JsonIgnore
    public Expense convertToExpense() {
        Expense result = new Expense();

        result.setAmount(this.amount);
        result.setExpenseDate(this.date);
        result.setReason(this.reason);
        //Optional used if vat is not exists at input
        result.setVat(Optional.ofNullable(this.vat).orElse(this.amount.multiply(VAT, MathContext.DECIMAL128).divide(TOTAL, MathContext.DECIMAL128)));

        return result;
    }

    /**
     * Converts from database expense to database expense
     */
    @JsonIgnore
    public static ExpenseData convertToThis(Expense expense) {
        return new ExpenseData(expense.getExpenseDate(), expense.getReason(), expense.getAmount(), expense.getVat());
    }
}
