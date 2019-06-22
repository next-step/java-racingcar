package com.java.jaeheon.step2;

import com.java.jaeheon.step2.view.InputView;
import com.java.jaeheon.step2.view.ResultView;

public class RacingMain {

    public static void main(String[] args) {

        String nameOfCars = InputView.inputViewNameOfCars();
        int numberOfAttempts = InputView.inputViewNumberOfAttempts();

        RacingGame racingGame = new RacingGame(nameOfCars, numberOfAttempts);
        racingGame.carRacingStart();
        ResultView.resultViewRacing(racingGame.racingResult());
    }

}
