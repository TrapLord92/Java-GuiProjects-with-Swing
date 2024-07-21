package com.traplord.plans;

public abstract class Risk {
    float premium;
    float covarege;
    float ceiling;


    public boolean isCovered(String[] riskCovered, String[] claimed) {
        int i = 0;
        int j = 0;

        for (i = 0; i < claimed.length; i++) {
            for (j = 0; j < riskCovered.length; j++) {
                if (claimed[i] == riskCovered[j]) {
                    break;
                }
                if (j == riskCovered.length) {
                    return false;
                }
            }
        }
        return true;


    }


    public abstract float getPremium();
    public abstract float getCovarege();
    public abstract float getCeiling();










}
