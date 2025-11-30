package controller;

import domain.Car;
import domain.TryNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private TryNumber tryNumber;

    public RacingGame(String carNames, int tryNumber) {
        this(createCars(parseCarNames(carNames)), new TryNumber(tryNumber));
    }

    public RacingGame(List<Car> cars, TryNumber tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    private static List<Car>  createCars(List<String> parsedCarNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : parsedCarNames) {
            cars.add(new Car(carName, 0));
        }

        return cars;
    }

    private static List<String> parseCarNames(String carNameInput) {
        return Arrays.asList(carNameInput.split(","));
    }
}
