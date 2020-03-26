package controller;

import domain.Car;
import domain.RacingGame;
import ui.InputView;
import ui.ResultView;
import util.CarFactory;
import util.RandomNumberFactory;

import java.util.List;

public class RacingGameController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String names = inputView.getName();
        int tryCount = inputView.getTryCount();
        List<Car> cars = CarFactory.createCars(names);
        RacingGame racingGame = new RacingGame(cars);
        ResultView resultView = new ResultView();
        resultView.printStartMessage();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playGame(RandomNumberFactory.getRandomNumbers(cars.size()));
            resultView.printCurrentLocation(cars);
        }
        resultView.printWinners(racingGame.getWinners());
    }
}
