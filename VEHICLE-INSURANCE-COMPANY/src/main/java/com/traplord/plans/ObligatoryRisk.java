package com.traplord.plans;

public class ObligatoryRisk extends Risk  {

    @Override
    public float getPremium() {
        return 0.05f;
    }

    @Override
    public float getCovarege() {
        return 0.9f;
    }

    @Override
    public float getCeiling() {
        return 4;
    }

    public String[] obligatoryRiskCovered={
            "Third Party Damage",
    };

}
