package step3.service;

import step3.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    public static List<List<Integer>> scoreboard = new ArrayList<>();

    private List<Car> cars;
    private int numberOfAttempts;

    public CarRacingGame(List<Car> cars, int numberOfAttempts) {
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public void start() {
        for (int i = 0; i < numberOfAttempts; i++) {
            cars.forEach(Car::move);
            recordScoreboard();
        }
    }

    public void recordScoreboard() {
        scoreboard.add(cars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList()));
    }

}
