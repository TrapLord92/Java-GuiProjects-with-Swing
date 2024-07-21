package com.traplord;

import java.io.Serializable;

public class SubscriptionCycle implements Serializable {
    //classes that save and data and load need to implement serializable interface
    private String startDate;
    private String endDate;

    public SubscriptionCycle(String endDate, String startDate) {
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "SubscriptionCycle{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
