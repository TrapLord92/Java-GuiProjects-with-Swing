package com.traplord.policy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Policy implements Serializable {

    static  int policyNB=0; //class variable

    Vehicle vehicle;

    List<String> riskCoveredLIST =new ArrayList<>();


    List<Float> premiumLIST=new ArrayList<>();
    List<Float> coverageLIST=new ArrayList<>();
    List<Float> ceilingLIST=new ArrayList<>();
    int validityYear;
    LocalDate policyDate;

    public Policy(Vehicle vehicle, List<String> riskCoveredLIST,
                  List<Float> premiumLIST,
                  List<Float> coverageLIST,
                  List<Float> ceilingLIST, int validityYear,
                  LocalDate policyDate) {

        this.vehicle = vehicle;
        this.riskCoveredLIST = riskCoveredLIST;
        this.premiumLIST = premiumLIST;
        this.coverageLIST = coverageLIST;
        this.ceilingLIST = ceilingLIST;
        this.validityYear = validityYear;
        this.policyDate = policyDate;
        policyNB+=1;
    }


    public static int getPolicyNB() {
        return policyNB;
    }

    public static void setPolicyNB(int policyNB) {
        Policy.policyNB = policyNB;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<String> getRiskCoveredLIST() {
        return riskCoveredLIST;
    }

    public void setRiskCoveredLIST(List<String> riskCoveredLIST) {
        this.riskCoveredLIST = riskCoveredLIST;
    }

    public List<Float> getPremiumLIST() {
        return premiumLIST;
    }

    public void setPremiumLIST(List<Float> premiumLIST) {
        this.premiumLIST = premiumLIST;
    }

    public List<Float> getCoverageLIST() {
        return coverageLIST;
    }

    public void setCoverageLIST(List<Float> coverageLIST) {
        this.coverageLIST = coverageLIST;
    }

    public List<Float> getCeilingLIST() {
        return ceilingLIST;
    }

    public void setCeilingLIST(List<Float> ceilingLIST) {
        this.ceilingLIST = ceilingLIST;
    }

    public int getValidityYear() {
        return validityYear;
    }

    public void setValidityYear(int validityYear) {
        this.validityYear = validityYear;
    }

    public LocalDate getPolicyDate() {
        return policyDate;
    }

    public void setPolicyDate(LocalDate policyDate) {
        this.policyDate = policyDate;
    }






}
