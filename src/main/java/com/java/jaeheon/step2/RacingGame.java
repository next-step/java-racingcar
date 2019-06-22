package com.java.jaeheon.step2;

import com.java.jaeheon.step2.model.CarRacing;
import com.java.jaeheon.step2.view.InputView;

public class RacingGame {

    public static void main(String[] args) {

        String nameOfCars = InputView.inputViewNameOfCars();
        int numberOfAttempts = InputView.inputViewNumberOfAttempts();

        CarRacing carRacing = new CarRacing(nameOfCars, numberOfAttempts);
        carRacing.carRacingStart();
        carRacing.resultViewer();
    }
}
