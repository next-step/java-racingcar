package main.java.racingCar.controller;

import main.java.racingCar.model.Car;
import main.java.racingCar.view.InputViewer;

public class Game {
    public static void main(String args[]){
        System.out.println("--");
        RacingGame racingGame = new RacingGame();
        InputViewer inputViewer=new InputViewer();
        Car[] racingCar = racingGame.setAllCars(inputViewer.carInputViewer());
        racingCar= racingGame.moveAllCars(racingCar, inputViewer.tryInputViewer());
        racingGame.showAllCarsPosition(racingCar);
    }
}
