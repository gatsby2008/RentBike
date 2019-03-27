package com.sote.bike;

public class BikeForWeek extends AbstractBikeForRent{
    private final double price = 60;
    @Override
    public double getPrice(){
        return price;
    }
}
