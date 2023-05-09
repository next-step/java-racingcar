package dto;

import domain.*;

public class RaceInfo {
    private final NumberOfCars numberOfCars;
    private final NumberOfRaces numberOfRaces;
    private final Car car;

    public RaceInfo(NumberOfCars numberOfCars, NumberOfRaces numberOfRaces, Car car) {
        this.numberOfCars = numberOfCars;
        this.numberOfRaces = numberOfRaces;
        this.car = car;
    }

    public NumberOfCars getCarNumber() {
        return numberOfCars;
    }

    public NumberOfRaces getRaceNumber() {
        return numberOfRaces;
    }

    public Car getCar() { return Car.createCopy(car); }
}
