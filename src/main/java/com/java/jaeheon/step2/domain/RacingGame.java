package com.java.jaeheon.step2.domain;

import java.util.*;

public class RacingGame {
    private Map<Integer, List<Car>> recordByAttempts = new HashMap<>();

    private static final int CONDITION_LIMIT = 10;
    private final Random random = new Random();

    private final int numberOfAttempts;
    private CarManagement carManagement;

    public RacingGame(String nameOfCars, int numberOfAttempts) {
        this.carManagement = carRegister(nameOfCars);
        this.numberOfAttempts = numberOfAttempts;
    }

    public RacingGame(List<Car> cars, int numberOfAttempts) {
        this.carManagement = new CarManagement(cars);
        this.numberOfAttempts = numberOfAttempts;
    }

    private CarManagement carRegister(String nameOfCars) {
        List<Car> cars = new ArrayList<>();
        for (String nameOfCar : nameOfCars.trim().split(",")) {
            cars.add(new Car(nameOfCar));
        }
        return new CarManagement(cars);
    }

    public void carRacingStart() {
        for (int attempts = 1; attempts <= numberOfAttempts; attempts++) {
            carManagement = race();
            recordByAttempts.put(attempts, carManagement.getCars());
        }
    }

    private CarManagement race() {
        List<Car> cars = new ArrayList<>();
        for (Car car : carManagement.getCars()) {
            cars.add(car.attemptsToMove(createCondition()));
        }
        return new CarManagement(cars);
    }

    private int createCondition() {
        return random.nextInt(CONDITION_LIMIT);
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public int getNumberOfCars() {
        return carManagement.getSize();
    }

    public List<Car> getAttemptsCars(int attempts) {
        return recordByAttempts.get(attempts);
    }

    public List<Car> getWinner() {
        return Winners.findWinners(carManagement.getCars());
    }

}
