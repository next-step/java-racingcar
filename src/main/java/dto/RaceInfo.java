package dto;

import domain.NumberOfCars;
import domain.NumberOfRaces;

public class RaceInfo {
    private final NumberOfCars numberOfCars;
    private final NumberOfRaces numberOfRaces;

    public RaceInfo(NumberOfCars numberOfCars, NumberOfRaces numberOfRaces) {
        this.numberOfCars = numberOfCars;
        this.numberOfRaces = numberOfRaces;
    }

    public NumberOfCars getCarNumber() {
        return numberOfCars;
    }

    public NumberOfRaces getRaceNumber() {
        return numberOfRaces;
    }
}
