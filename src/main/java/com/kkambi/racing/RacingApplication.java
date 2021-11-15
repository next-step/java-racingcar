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
        String[] carNameList = inputView.getCarNameList();
        int numberOfAttempts = inputView.getNumberOfTries();

        List<Car> carList = composeCarList(carNameList);

        ResultView resultView = new ResultView();
        resultView.printPhrase();

        for (int times = 1; times <= numberOfAttempts; times++) {
            tryToMoveCarList(carList);
            resultView.printInformation(carList);
        }
        resultView.printWinners(chooseWinners(carList));
    }

    private static List<Car> composeCarList(String[] carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(new Car(0, carName));
        }
        return carList;
    }

    private static void tryToMoveCarList(List<Car> carList) {
        for (Car car : carList) {
            car.tryToMove(Dice.roll(10));
        }
    }

    private static List<Car> chooseWinners(List<Car> carList) {
        Car maxLocationCar = Collections.max(carList, Comparator.comparing(Car::getLocation));
        return carList.stream()
                .filter(car -> car.getLocation().equals(maxLocationCar.getLocation()))
                .collect(Collectors.toList());
    }
}
