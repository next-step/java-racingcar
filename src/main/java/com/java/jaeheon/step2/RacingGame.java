package com.java.jaeheon.step2;

import com.java.jaeheon.step2.controller.CarController;
import com.java.jaeheon.step2.model.CarManagement;
import com.java.jaeheon.step2.model.CarRacing;
import com.java.jaeheon.step2.view.InputView;

public class RacingGame {

    public static void main(String[] args) {

        int numberOfCars = InputView.inputViewNumberOfCars();
        int numberOfAttempts = InputView.inputViewNumberOfAttempts();

        CarManagement carManagement = CarController.carRegister(numberOfCars);

        CarRacing carRacing = new CarRacing(carManagement, numberOfAttempts);
        carRacing.carRacingStart();
    }
}
