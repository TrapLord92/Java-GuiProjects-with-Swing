package com.traplord.policy;

import java.io.Serializable;

public class Customer implements Serializable {

    String fname,lname,city;
    int c_phone;
    Policy policy;

    public Customer(){

    }

    public Customer(String fname, String lname,
                    String city, int c_phone,
                    Policy policy) {
        this.fname = fname;
        this.lname = lname;
        this.city = city;
        this.c_phone = c_phone;
        this.policy = policy;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getC_phone() {
        return c_phone;
    }

    public void setC_phone(int c_phone) {
        this.c_phone = c_phone;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    @Override
    public String toString() {
        return
                "fname :" + fname + '\n' +
                " lname : " + lname + '\n' +
                "city :" + city + '\n' +
                "c_phone : " + c_phone +
                " policy :" + policy
               ;
    }
}
