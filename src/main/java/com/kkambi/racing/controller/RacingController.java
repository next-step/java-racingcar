package com.kkambi.racing.controller;

import com.kkambi.racing.domain.Car;
import com.kkambi.racing.view.InputView;
import com.kkambi.racing.view.TotalView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private final TotalView totalView = new TotalView();
    private final List<Car> carList = new ArrayList<>();

    public void start() {
        InputView.InputCommand inputCommand = totalView.getInput();

        composeCars(inputCommand.getNumberOfCars());

        for (int times = 0; times < inputCommand.getNumberOfAttempts(); times++) {
            moveCars();
            totalView.printLocation(carList);
        }
    }

    private void composeCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            carList.add(new Car());
        }
    }

    private void moveCars() {
        for (Car car : carList) {
            car.attemptToMove();
        }
    }
}
