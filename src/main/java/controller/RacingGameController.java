package controller;

import domain.Car;
import domain.RacingGame;
import ui.InputView;
import util.CarFactory;
import util.RandomNumberFactory;

import java.util.List;

public class RacingGameController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String names = inputView.getName();
        List<Car> cars = CarFactory.createCars(names);
        RacingGame racingGame = new RacingGame(cars);
        int tryCount = inputView.getTryCount();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playGame(RandomNumberFactory.getRandomNumbers(cars.size()));
        }


    }
}
