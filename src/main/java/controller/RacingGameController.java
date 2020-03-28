package controller;

import domain.Cars;
import domain.RacingGame;
import ui.InputView;
import ui.ResultView;
import util.RandomNumberFactory;

public class RacingGameController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String names = inputView.getName();
        int tryCount = inputView.getTryCount();
        Cars cars = new Cars(names);
        RacingGame racingGame = new RacingGame();
        ResultView resultView = new ResultView();
        resultView.printStartMessage();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playGame(cars, RandomNumberFactory.getRandomNumbers(cars.getCars().size()));
            resultView.printCurrentLocation(cars);
        }
        resultView.printWinners(cars.getWinners());
    }
}
