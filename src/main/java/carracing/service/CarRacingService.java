package carracing.service;

import carracing.model.Cars;

public class CarRacingService {

    private Cars cars;

    private final Integer tryCount;

    public CarRacingService(Cars cars, Integer tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public Cars gameStart() {
        for (int i = 0; i < tryCount; i++) {
            cars.carsRace();
        }

        return cars;
    }

}
