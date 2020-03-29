package controller;

import domain.Car;
import domain.Cars;
import domain.RacingGame;
import strategy.RandomMovableStrategy;
import ui.InputView;
import ui.ResultView;

public class RacingGameController {

    public static void main(String[] args) {
        Cars cars = new Cars(InputView.getCars());
        int tryCount = InputView.getTryCount();

        RandomMovableStrategy randomMovableStrategy = new RandomMovableStrategy();
        RacingGame racingGame = new RacingGame(randomMovableStrategy);
        ResultView.printStartMessage();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playGame(cars);
            ResultView.printCurrentLocation(cars);
        }

        ResultView.printWinners(cars.getWinners());
    }
}
