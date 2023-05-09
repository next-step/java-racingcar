package domain;

import dto.RaceInfo;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final NumberOfRaces numberOfRaces;
    private final List<Car> cars = new ArrayList<>();

    public Race(RaceInfo raceInfo) {
        NumberOfCars numberOfCars = raceInfo.getCarNumber();
        this.numberOfRaces = raceInfo.getRaceNumber();
        for (int i = 0; i < numberOfCars.getValue(); i++) {
            cars.add(raceInfo.getCar());
        }
    }

    public RaceResult calculate() {
        RaceResult raceResult = new RaceResult();

        raceResult.add(GameResult.create(cars));
        for (int i = 0; i < numberOfRaces.getValue(); i++) {
            cars.forEach(Car::move);
            raceResult.add(GameResult.create(cars));
        }

        return raceResult;
    }
}
