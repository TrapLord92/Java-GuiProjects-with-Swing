package com.traplord;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Account implements Serializable ,AccountInterfeice{
    //Variables
    static int nextAccountNo=10; //class variable
    int accountNo;
    String owner;
    City city;
    char gender;
    double balance;
    Date openDate;


    //construtor


    public Account() {
    }

    public Account(String owner, City city, char gender) {

        accountNo=nextAccountNo;

        this.owner = owner;
        this.city = city;
        this.gender = gender;
        balance = 0.0;
        openDate=null;
    }

    public Account(int accountNo, String owner, City city, char gender, double balance) {
        this.accountNo = accountNo;
        this.owner = owner;
        this.city = city;
        this.gender = gender;
        setBalance(balance);
    }

    @Override
    public void setBalance(double b) {
        balance = b>0.0 ? b : 0.0;
    }

    @Override
    public String toString() {
        return  accountNo +
                "     " + owner + '\'' +
                "    " + city +
                "   " + gender +
                "  " + balance +
                "  " + openDate ;
    }



    @Override
    public int compareTo(Object o) {
       return this.owner.compareTo(((Account) o).owner);

    }



    public  void deposit(double amount){
        if (amount > 0){
            setBalance(balance +amount);
        }
    }
    public  double withdraw(double amount){
        if (amount>0){
            if(amount< balance){
                setBalance(balance - amount);

            }else{
                amount=balance;
            }
            return amount;
        }
        return  0.0;
    }


}
