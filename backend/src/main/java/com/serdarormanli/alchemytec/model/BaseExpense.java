package com.serdarormanli.alchemytec.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by serdar.ormanli on 11.11.2015.
 */
public class BaseExpense {
    Date expenseDate;
    String reason;
    BigDecimal amount;
    BigDecimal vat;

    public BaseExpense() {
    }

    public BaseExpense(Date expenseDate, String reason, BigDecimal amount, BigDecimal vat) {
        this.expenseDate = expenseDate;
        this.reason = reason;
        this.amount = amount;
        this.vat = vat;
    }
}
