package com.sote.bike;

public class AbstractBikeForRent{
    private int periods;

    public double getPrice() {
        return getPrice();
    }


    public double getTotal() {
        return periods * getPrice();
    }


    public void setQuantityOfPeriods(int periodsOfTime) {
        periods = periodsOfTime;
    }
}
