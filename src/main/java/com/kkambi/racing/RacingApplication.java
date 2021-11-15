package com.kkambi.racing;

import com.kkambi.racing.domain.Car;
import com.kkambi.racing.util.Dice;
import com.kkambi.racing.view.InputView;
import com.kkambi.racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCars = inputView.getNumberOfCars();
        int numberOfAttempts = inputView.getNumberOfTries();

        List<Car> carList = composeCarList(numberOfCars);

        ResultView resultView = new ResultView();
        resultView.printPhrase();

        for (int times = 1; times <= numberOfAttempts; times++) {
            tryToMoveCarList(carList);
            resultView.printLocations(carList);
        }
    }

    private static List<Car> composeCarList(int numberOfCars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    private static void tryToMoveCarList(List<Car> carList) {
        for (Car car : carList) {
            car.tryToMove(Dice.roll(10));
        }
    }
}
