package com.sote.bike


import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class RentBikeSpec extends Specification{
    @Subject
    Rental rental;

    def setup(){
        rental = new Rental()
    }
    @Unroll
    def "Rental by hour, charging \$5 per hour. Result when different number of hours are evaluated"() {
        given:"a bike"
            def bike = BikeForRentFactory.getBikeForRent(BikeForRentType.HOURS)
        when:"the bike is rented for 6 hours"
            bike.setQuantityOfPeriods(hoursRented)
            rental.addRentedBike(bike)
        then:"the total rented bikes should be 1 and the total price should be hours rented by price"
            rental.getTotalRentedBikes() == 1
            rental.getTotalAmountRentedBikes() == result
        where: "hours rented are... result is..."
            hoursRented  || result
                1        || 1 * 5
                5        || 5 * 5
                3        || 3 * 5

    }
    @Unroll
    def "Rental by day, charging \$20 a day. Result when different number of days are evaluated"() {
        given:"a bike"
            def bike = BikeForRentFactory.getBikeForRent(BikeForRentType.DAYS)
        when:"the bike is rented"
            bike.setQuantityOfPeriods(daysRented)
            rental.addRentedBike(bike)
        then:"the total rented bikes should be 1 and the total price should be days rented by price"
            rental.getTotalRentedBikes() == 1
            rental.getTotalAmountRentedBikes() == result
        where: "days rented are... result is..."
            daysRented  ||  result
                1       ||  1 * 20
                5       ||  5 * 20
                3       ||  3 * 20

    }
    @Unroll
    def "Rental by week, changing \$60 a week. Result when different number of weeks are evaluated"() {
        given:"a bike"
            def bike = BikeForRentFactory.getBikeForRent(BikeForRentType.WEEKS)
        when:"the bike is rented"
            bike.setQuantityOfPeriods(weeksRented)
            rental.addRentedBike(bike)
        then:"the total rented bikes should be 1 and the total price should be number of week rented by price"
            rental.getTotalRentedBikes() == 1
            rental.getTotalAmountRentedBikes() == result
        where: "weeks rented are... result is..."
            weeksRented  || result
                1            || 1 * 60
                5            || 5 * 60
                3            || 3 * 60
    }
    @Unroll
    def "Family Rental, discount of 30% is applied to 3 rentals"() {
        given: "3 bikes"
            def bikeByHour = BikeForRentFactory.getBikeForRent(BikeForRentType.HOURS)
            def bikeByWeek = BikeForRentFactory.getBikeForRent(BikeForRentType.WEEKS)
            def bikeByDays = BikeForRentFactory.getBikeForRent(BikeForRentType.DAYS)
        when: "each bike is rented in diferent ways, by days, hours and weeks"
            bikeByHour.setQuantityOfPeriods(hoursRented)
            bikeByWeek.setQuantityOfPeriods(weeksRented)
            bikeByDays.setQuantityOfPeriods(daysRented)
            rental.addRentedBike(bikeByHour)
            rental.addRentedBike(bikeByWeek)
            rental.addRentedBike(bikeByDays)
        then: "total rented bikes should be 3 and the total amount should contains a 30% of discount"
            rental.getTotalRentedBikes() == 3
            rental.getTotalAmountRentedBikes() == result
        where: "hours rented, days rented, weeks rented are... result is"
            hoursRented     ||    daysRented       ||    weeksRented     ||     result
                1           ||      1              ||       1            ||   (1 * 5 + 1 * 20 + 1 * 60) * 0.7
                8           ||      5              ||       2            ||   (8 * 5 + 5 * 20 + 2 * 60) * 0.7
                10          ||      3              ||       1            ||   (10 * 5 + 3 * 20 + 1 * 60) * 0.7
    }
    @Unroll
    def "Family Rental, discount of 30% is applied to 4 rentals"() {
        given: "4 bikes"
            def bikeByHour = BikeForRentFactory.getBikeForRent(BikeForRentType.HOURS)
            def bikeByWeek = BikeForRentFactory.getBikeForRent(BikeForRentType.WEEKS)
            def bikeByDays = BikeForRentFactory.getBikeForRent(BikeForRentType.DAYS)
            def bikeByDays2 = BikeForRentFactory.getBikeForRent(BikeForRentType.DAYS)
        when: "each bike is rented in diferent ways, by days, hours and weeks"
            bikeByHour.setQuantityOfPeriods(hoursRented)
            bikeByWeek.setQuantityOfPeriods(weeksRented)
            bikeByDays.setQuantityOfPeriods(daysRented)
            bikeByDays2.setQuantityOfPeriods(daysRented)
            rental.addRentedBike(bikeByHour)
            rental.addRentedBike(bikeByWeek)
            rental.addRentedBike(bikeByDays)
            rental.addRentedBike(bikeByDays2)
        then: "total rented bikes should be 4 and the total amount should contains a 30% of discount"
            rental.getTotalRentedBikes() == 4
            rental.getTotalAmountRentedBikes() == result
        where: "hours rented, days rented, weeks rented are... result is"
            hoursRented     ||    daysRented       ||    weeksRented     ||     result
                1           ||      1              ||       1            ||   (1 * 5 + 1 * 20 * 2 + 1 * 60) * 0.7
                8           ||      5              ||       2            ||   (8 * 5 + 5 * 20 * 2 + 2 * 60) * 0.7
                10          ||      3              ||       1            ||   (10 * 5 + 3 * 20  *2 + 1 * 60) * 0.7
    }
    @Unroll
    def "Family Rental, discount of 30% is applied to 5 rentals"() {
        given: "5 bikes"
            def bikeByHour = BikeForRentFactory.getBikeForRent(BikeForRentType.HOURS)
            def bikeByWeek = BikeForRentFactory.getBikeForRent(BikeForRentType.WEEKS)
            def bikeByWeek2 = BikeForRentFactory.getBikeForRent(BikeForRentType.WEEKS)
            def bikeByDays = BikeForRentFactory.getBikeForRent(BikeForRentType.DAYS)
            def bikeByDays2 = BikeForRentFactory.getBikeForRent(BikeForRentType.DAYS)
        when: "each bike is rented in diferent ways, by days, hours and weeks"
            bikeByHour.setQuantityOfPeriods(hoursRented)
            bikeByWeek.setQuantityOfPeriods(weeksRented)
            bikeByWeek2.setQuantityOfPeriods(weeksRented)
            bikeByDays.setQuantityOfPeriods(daysRented)
            bikeByDays2.setQuantityOfPeriods(daysRented)
            rental.addRentedBike(bikeByHour)
            rental.addRentedBike(bikeByWeek)
            rental.addRentedBike(bikeByWeek2)
            rental.addRentedBike(bikeByDays)
            rental.addRentedBike(bikeByDays2)
        then: "total rented bikes should be 5 and the total amount should contains a 30% of discount"
            rental.getTotalRentedBikes() == 5
            rental.getTotalAmountRentedBikes() == result
        where: "hours rented, days rented, weeks rented are... result is"
            hoursRented     ||    daysRented       ||    weeksRented     ||     result
                1           ||      1              ||       1            || (1 * 5 + 1 * 20 * 2 + 1 * 60 * 2) * 0.7
                8           ||      5              ||       2            || (8 * 5 + 5 * 20 * 2 + 2 * 60 * 2) * 0.7
                10          ||      3              ||       1            || (10 * 5 + 3 * 20  *2 + 1 * 60 * 2) * 0.7
    }
    @Unroll
    def "Family Rental, discount of 30% is not applied to 6 rentals"() {
        given: "6 bikes"
        def bikeByHour = BikeForRentFactory.getBikeForRent(BikeForRentType.HOURS)
        def bikeByHour2 = BikeForRentFactory.getBikeForRent(BikeForRentType.HOURS)
        def bikeByWeek = BikeForRentFactory.getBikeForRent(BikeForRentType.WEEKS)
        def bikeByWeek2 = BikeForRentFactory.getBikeForRent(BikeForRentType.WEEKS)
        def bikeByDays = BikeForRentFactory.getBikeForRent(BikeForRentType.DAYS)
        def bikeByDays2 = BikeForRentFactory.getBikeForRent(BikeForRentType.DAYS)
        when: "each bike is rented in diferent ways, by days, hours and weeks"
            bikeByHour.setQuantityOfPeriods(hoursRented)
            bikeByHour2.setQuantityOfPeriods(hoursRented)
            bikeByWeek.setQuantityOfPeriods(weeksRented)
            bikeByWeek2.setQuantityOfPeriods(weeksRented)
            bikeByDays.setQuantityOfPeriods(daysRented)
            bikeByDays2.setQuantityOfPeriods(daysRented)
            rental.addRentedBike(bikeByHour)
            rental.addRentedBike(bikeByHour2)
            rental.addRentedBike(bikeByWeek)
            rental.addRentedBike(bikeByWeek2)
            rental.addRentedBike(bikeByDays)
            rental.addRentedBike(bikeByDays2)
        then: "total rented bikes should be 3 and the total amount should NOT contains a 30% of discount"
            rental.getTotalRentedBikes() == 6
            rental.getTotalAmountRentedBikes() == result
        where: "hours rented, days rented, weeks rented are... result is"
            hoursRented     ||    daysRented       ||    weeksRented     ||     result
                1           ||      1              ||       1            ||  (1 * 5 * 2 + 1 * 20 * 2 + 1 * 60 * 2)
                8           ||      5              ||       2            ||  (8 * 5 * 2 + 5 * 20 * 2 + 2 * 60 * 2)
                10          ||      3              ||       1            ||  (10 * 5 * 2 + 3 * 20  *2 + 1 * 60 * 2)
        }
    def cleanup(){
        rental.getRentedBikes().clear();
    }

}
