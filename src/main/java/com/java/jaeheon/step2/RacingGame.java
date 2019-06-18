package com.java.jaeheon.step2;

public class RacingGame {

    public static void main(String[] args) {

        int numberOfCars = InputView.inputViewNumberOfCars();
        int numberOfAttempts = InputView.inputViewNumberOfAttempts();
        ResultView.toTheNextLine();

        CarManagement carManagement = new CarManagement();
        carManagement.registerByNumber(numberOfCars);

        CarRacing carRacing = new CarRacing(carManagement, numberOfAttempts);
        carRacing.carRacingStart();
    }
}
