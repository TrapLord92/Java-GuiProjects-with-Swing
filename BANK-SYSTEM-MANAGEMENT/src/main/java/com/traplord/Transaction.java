package com.traplord;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements  Comparable<Transaction> , Serializable {

    //variables

    private static int next=1;
    int trsNo;

    Account acc;
    LocalDate date;

    char operation;
    double amount;


    public Transaction(char operation, LocalDate date, Account acc, double amount) {
        this.operation = operation;
        this.date = date;
        this.acc = acc;
        this.amount = amount;
        trsNo=next++;
    }

    @Override
    public int compareTo(Transaction o) {
        return this.trsNo-o.trsNo;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "acc=" + acc +
                ", trsNo=" + trsNo +
                ", date=" + date +
                ", operation=" + operation +
                ", amount=" + amount +
                '}';
    }

    public Account getAcc() {
        return acc;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public char getOperation() {
        return operation;
    }

    public int getTrsNo() {
        return trsNo;
    }
}
