package com.traplord;

import java.io.Serializable;

public class Subscription implements Serializable {
    //Classes that save and data and load need to implement serializable interface

    private int installFee; //Fixed fee 10$/tv
    private int nbTv;
    private Subscriber subscriber;
    private SubscriptionCycle cycle;
    private String datee;

    //    total fee
    private int totalFee;

    public Subscription(int nbTv, Subscriber subscriber, SubscriptionCycle cycle, String datee) {
        this.nbTv = nbTv;
        this.subscriber = subscriber;
        this.cycle = cycle;
        this.datee = datee;
        this.installFee = nbTv * 10;
    }

    public int getNbTv() {
        return nbTv;
    }

    public void setNbTv(int nbTv) {
        this.nbTv = nbTv;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public SubscriptionCycle getCycle() {
        return cycle;
    }

    public void setCycle(SubscriptionCycle cycle) {
        this.cycle = cycle;
    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }

    public int getTotalFee() {
        totalFee=installFee+5;
        return totalFee;
    }


    @Override
    public String toString() {
        return "Subscription{" +
                "installFee=" + installFee +
                ", nbTv=" + nbTv +
                ", subscriber=" + subscriber +
                ", cycle=" + cycle +
                ", today='" + datee + '\'' +
                '}';
    }
}
