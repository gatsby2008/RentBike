package com.sote.bike;

public class BikeForHour extends AbstractBikeForRent {
    private final double price = 5;
    @Override
    public double getPrice(){
        return price;
    }
}
