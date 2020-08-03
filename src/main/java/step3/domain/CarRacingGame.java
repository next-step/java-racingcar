package step3.domain;

import step3.factory.CarFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private final List<Car> cars;
    private final int numberOfAttempts;
    private List<List<Car>> rapResults = new ArrayList<>();

    public CarRacingGame(int numberOfCars, int numberOfAttempts) {
        this.cars = CarFactory.create(numberOfCars);
        this.numberOfAttempts = numberOfAttempts;
    }

    public void start() {
        for (int i = 0; i < numberOfAttempts; i++) {
            List<Car> rapResult = cars.stream().map(Car::move).map(Car::clone).collect(Collectors.toList());
            rapResults.add(rapResult);
        }
    }

    public List<List<Car>> getRapResults() {
        return rapResults;
    }

}
