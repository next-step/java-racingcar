package CarRacingGame;

import java.util.Scanner;

public class CarRacingGame {
    static CarRacingGameUtils cars = new CarRacingGameUtils();

    public static void main(String[] args) {

        int numberOfCars = InputView.getNumberOfCars();
        int numberOfAttempts = InputView.getNumberOfAttempts();

        cars.initialCarSettings(numberOfCars);
        cars.printMovingCars(numberOfAttempts);
    }
}

