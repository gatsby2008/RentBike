The proposed solution is based on the factory method design patther. The classes implemented are:
BikeForRentFactory: creates the classes (BikeForDay, BikeForHour, BikeForWeek) depending on the type of rental selected
AbstractBikeForRent: an abstract class that contains the common operation for all its children BikeForDay, BikeForHour and BikeForWeek
BikeForDay, BikeForHour, BikeForWeek: the main difference between each one is the price.
Rental: is the class in charge of the amount calculation according to the assignment

Spock framework(1.3-groovy-2.5) was used for unit test

To run the application that was build using Gradle version 5.2.1 and groovy 2.5.6, just run the following command
gradle clean build
After that, you will be able to see a report in the folder build/spock-reports opening the file index.html
