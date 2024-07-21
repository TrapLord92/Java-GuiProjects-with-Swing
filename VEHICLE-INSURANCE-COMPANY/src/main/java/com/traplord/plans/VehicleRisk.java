package com.traplord.plans;

public class VehicleRisk extends Risk  {


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
        return 6;
    }

        public String[] VehicleRiskCovered={
            "Vehicle Damage",
    };

}
