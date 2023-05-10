package carracing.controller;

import carracing.domain.Car;
import carracing.domain.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private final Cars cars;

    public CarRacingGame(String[] names) {
        this.cars = toCars(names);
    }

    private Cars toCars(String[] carNames) {
        return new Cars(Arrays.stream(carNames)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars getCars() {
        return cars;
    }

    public void play() {
        cars.go();
    }

    public List<Car> getWinners() {
        int maxDistance = cars.getMaxDistance();
        return cars.getCarsAtCertainDistance(maxDistance);
    }
}
