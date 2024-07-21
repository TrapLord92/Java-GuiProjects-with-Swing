package com.traplord.plans;

public class AllRisks extends Risk  {
    @Override
    public float getPremium() {
        return 0.075f;
    }

    @Override
    public float getCovarege() {
        return 1f;
    }

    @Override
    public float getCeiling() {
        return 10;
    }

        public String[] allRiskCovered={
          "Driver Damage",
                 "Property Damage",
                 "Liability",
                 "Medical Expenses",
                 "Work Compensation",
                 "Uninsured Motorists",
                 "Personal Injury",
                 "Environmental Factors",
                 "Environmental Contamination",
                 "Environmental Damage",
                 "Environmental Liability",
                 "Environmental Contamination Liability",
                 "Environmental Damage Liability",
                 "Environmental Contamination Damage Liability",
                 "Environmental Liability Damage Liability",
                 "Environmental Contamination Liability Damage Liability",
                 "Environmental Contamination Damage Liability Damage Liability",
                 "Environmental Liability Damage Liability Damage Liability",
                 "Environmental Contamination Liability Damage Liability Damage Liability",
                 "Environmental Contamination Damage Liability Damage Liability Damage Liability",
                 "Environmental Liability Damage Liability Damage Liability Damage Liability",
                 "Environmental Contamination Li"

    };

}
