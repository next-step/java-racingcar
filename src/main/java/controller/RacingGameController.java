package controller;

import domain.Cars;
import domain.RacingGame;
import strategy.RandomMovableStrategy;
import ui.InputView;
import ui.ResultView;

public class RacingGameController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String names = inputView.getName();
        int tryCount = inputView.getTryCount();

        Cars cars = new Cars(names);
        RandomMovableStrategy randomMovableStrategy = new RandomMovableStrategy();
        RacingGame racingGame = new RacingGame();
        ResultView.printStartMessage();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playGame(cars, randomMovableStrategy);
            ResultView.printCurrentLocation(cars);
        }

        ResultView.printWinners(cars.getWinners());
    }
}
