package com.traplord.plans;

public class AssistenceRisk extends Risk  {
    @Override
    public float getPremium() {
        return 0.05f;
    }

    @Override
    public float getCovarege() {
        return 0.8f;
    }

    @Override
    public float getCeiling() {
        return 8;
    }

    public String[] assistanceRiskCovered ={
            "Fire",
            "Robbery",
            "Theft",
            "Transport",
            "Car Replacement",
    };

}
