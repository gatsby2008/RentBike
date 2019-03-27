package com.sote.bike;

public class BikeForDay extends AbstractBikeForRent{
    private final double price = 20;

    @Override
    public double getPrice() {
        return price;
    }

}
