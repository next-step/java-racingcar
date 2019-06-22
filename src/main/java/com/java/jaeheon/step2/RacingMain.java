package com.java.jaeheon.step2;

import com.java.jaeheon.step2.view.InputView;

public class RacingMain {

    public static void main(String[] args) {

        String nameOfCars = InputView.inputViewNameOfCars();
        int numberOfAttempts = InputView.inputViewNumberOfAttempts();

        RacingGame racingGame = new RacingGame(nameOfCars, numberOfAttempts);
        racingGame.carRacingStart();
        racingGame.resultViewer();
    }

}
