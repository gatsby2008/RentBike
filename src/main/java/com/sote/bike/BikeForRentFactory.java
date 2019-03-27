package com.sote.bike;

public abstract class BikeForRentFactory {
    public static AbstractBikeForRent getBikeForRent(BikeForRentType bikeForRentType){
        AbstractBikeForRent bikeForRent= null;
        switch (bikeForRentType){
            case DAYS:
                bikeForRent = new BikeForDay();
                break;
            case HOURS:
                bikeForRent = new BikeForHour();
                break;
            case WEEKS:
                bikeForRent = new BikeForWeek();
                break;
        }
        return bikeForRent;
    }
}
