package com.sote.bike;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Rental {
    public static final double DISCOUNT_IN_PERCENT = 30.0d;
    private ArrayList<AbstractBikeForRent> rentedBikes = new ArrayList<>();

    public ArrayList<AbstractBikeForRent> getRentedBikes() {
        return rentedBikes;
    }

    public void setRentedBikes(ArrayList<AbstractBikeForRent> rentedBikes) {
        this.rentedBikes = rentedBikes;
    }

    public void addRentedBike(AbstractBikeForRent bikeForRent) {
        rentedBikes.add(bikeForRent);
    }

    public double getTotalAmountRentedBikes() {
        double totalAmount =  rentedBikes.stream().mapToDouble(b->b.getTotal()).sum();
        double discount = 1 - DISCOUNT_IN_PERCENT/100;
        int totalRentedBikes = rentedBikes.size();
        if(totalRentedBikes>=3 && totalRentedBikes<=5){
            BigDecimal bd = new BigDecimal(totalAmount * discount);
            bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
            totalAmount = bd.doubleValue();
        }
        return totalAmount;

    }
    public int getTotalRentedBikes(){
        return rentedBikes.size();
    }

}
