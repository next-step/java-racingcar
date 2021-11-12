package com.kkambi.racing.controller;

import com.kkambi.racing.domain.Car;
import com.kkambi.racing.domain.CarFactory;
import com.kkambi.racing.domain.Racer;
import com.kkambi.racing.view.InputView;
import com.kkambi.racing.view.TotalView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private final TotalView totalView = new TotalView();
    private final List<Racer> racerList = new ArrayList<>();

    public void start() {
        InputView.InputCommand inputCommand = totalView.getInput();

        composeRacers(inputCommand.getNumberOfCars());

        for (int times = 1; times <= inputCommand.getNumberOfAttempts(); times++) {
            moveCars();
            totalView.printLocation(times, racerList);
        }
    }

    private void composeRacers(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            Car car = CarFactory.getCar();
            racerList.add(new Racer(car));
        }
    }

    private void moveCars() {
        for (Racer racer : racerList) {
            racer.attemptToMove();
        }
    }
}
