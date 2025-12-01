package controller;

import domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private TryNumber tryNumber;

    public RacingGame(String carNames, int tryNumber) {
        this(createCars(parseCarNames(carNames)), new TryNumber(tryNumber));
    }

    public RacingGame(List<Car> cars, TryNumber tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    private static List<Car> createCars(List<String> parsedCarNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : parsedCarNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private static List<String> parseCarNames(String carNameInput) {
        return Arrays.asList(carNameInput.split(","));
    }

    public boolean isEnd() {
        return tryNumber.isEnd();
    }

    public List<String> race() {
        tryNumber.increase();

        List<String> raceResult = new ArrayList<>();
        for (Car car : cars) {
            car.tryMoveForward(new RandomNumber());
            raceResult.add(car.toString());
        }

        return raceResult;
    }

    public List<String> winners() {
        return Winner.getWinners(cars);
    }
}
