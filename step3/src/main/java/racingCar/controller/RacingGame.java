package main.java.racingCar.controller;

import main.java.racingCar.model.Car;
import main.java.racingCar.view.InputViewer;
import main.java.racingCar.view.OutputViewer;

public class RacingGame {

    RacingGame(){}
    public Car[] setAllCars(int carNumber){
        Car[] racingCar = new Car[carNumber];
        for (int i = 0; i <carNumber; i++) {
            racingCar[i] = new Car();
        }
        return racingCar;
    }
    public Car[] moveAllCars(Car[] racingCar, int time) {
        for(int i = 0; i < time; i++){
            for (int j = 0; j < racingCar.length; j++) {
                racingCar[j].move();
            }
        }
        return racingCar;
    }
    public static void showAllCarsPosition(Car[] racingCar) {
        for (int i = 0; i <racingCar.length; i++) {
            OutputViewer.resultOutputViewer(racingCar[i].getPosition());
        }
    }


}
