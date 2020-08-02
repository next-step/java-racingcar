package step3.service;

import step3.factory.CarFactory;
import step3.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private List<List<Integer>> scoreboard = new ArrayList<>();

    private List<Car> cars;
    private int numberOfAttempts;

    public CarRacingGame(int numberOfCars, int numberOfAttempts) {
        this.cars = CarFactory.create(numberOfCars);
        this.numberOfAttempts = numberOfAttempts;
    }

    public void start() {
        for (int i = 0; i < numberOfAttempts; i++) {
            cars.forEach(car -> {
                int power = car.getPower();
                int forwardDistance = car.getForwardDistance(power);
                car.move(forwardDistance);
            });
            recordScoreboard();
        }
    }

    public void recordScoreboard() {
        scoreboard.add(cars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList()));
    }

    public List<List<Integer>> getScoreboard() {
        return scoreboard;
    }

}
