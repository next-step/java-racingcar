package carracing.controller;

import carracing.domain.Car;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarRacingGame {

    private static final int MAX_RANDOM_NUMBER = 10;
    private static final Random RANDOM = new Random();

    private final List<Car> cars;

    public CarRacingGame(String[] names) {
        this.cars = toCars(names);
    }

    private List<Car> toCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void play() {
        go();
    }

    public List<Car> getWinners() {
        int maxDistance = cars.stream().map(Car::getLocation).max(Comparator.comparingInt(o -> o)).orElse(0);
        return cars.stream()
                .filter(car -> car.isLocated(maxDistance))
                .collect(Collectors.toList());
    }

    private void go() {
        cars.forEach(car -> car.go(RANDOM.nextInt(MAX_RANDOM_NUMBER)));
    }
}
