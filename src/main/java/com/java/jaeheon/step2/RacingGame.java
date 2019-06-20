package com.java.jaeheon.step2;

import com.java.jaeheon.step2.controller.CarController;
import com.java.jaeheon.step2.model.CarManagement;
import com.java.jaeheon.step2.model.CarRacing;
import com.java.jaeheon.step2.view.InputView;

public class RacingGame {

    public static void main(String[] args) {

        String nameOfCars = InputView.inputViewNameOfCars();
        int numberOfAttempts = InputView.inputViewNumberOfAttempts();

        CarManagement carManagement = CarController.carRegister(nameOfCars);

        CarRacing carRacing = new CarRacing(carManagement, numberOfAttempts);
        carRacing.carRacingStart();
    }
}
