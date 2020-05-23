package main.java.racingCar.controller;

import main.java.racingCar.model.Car;
import main.java.racingCar.view.OutputViewer;

public class RacingGame {

    RacingGame() {
    }

    public static void showAllCarsPosition(Car[] racingCars) {
        for (int i = 0; i < racingCars.length; i++) {
            OutputViewer.resultOutputViewer(racingCars[i].getPosition());
        }
    }

    public Car[] setAllCars(int carNumber) {
        Car[] racingCars = new Car[carNumber];
        for (int i = 0; i < carNumber; i++) {
            racingCars[i] = new Car();
        }
        return racingCars;
    }

    public Car[] moveAllCars(Car[] racingCars, int time) {
        for (int i = 0; i < time; i++) {
            for (int j = 0; j < racingCars.length; j++) {
                racingCars[j].move();
            }
        }
        return racingCars;
    }


}
