package com.kkambi.racing;

import com.kkambi.racing.domain.Car;
import com.kkambi.racing.util.Dice;
import com.kkambi.racing.view.InputView;
import com.kkambi.racing.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.getCarNames();
        int numberOfAttempts = inputView.getNumberOfTries();

        List<Car> cars = composeCars(carNames);

        ResultView resultView = new ResultView();
        resultView.printPhrase();

        for (int times = 1; times <= numberOfAttempts; times++) {
            tryToMoveCars(cars);
            resultView.printInformation(cars);
        }
        resultView.printWinners(chooseWinners(cars));
    }

    private static List<Car> composeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(0, carName));
        }
        return cars;
    }

    private static void tryToMoveCars(List<Car> cars) {
        for (Car car : cars) {
            car.tryToMove(Dice.roll(10));
        }
    }

    private static List<Car> chooseWinners(List<Car> cars) {
        Car maxLocationCar = Collections.max(cars, Comparator.comparing(Car::getLocation));
        return cars.stream()
                .filter(car -> car.getLocation().equals(maxLocationCar.getLocation()))
                .collect(Collectors.toList());
    }
}
