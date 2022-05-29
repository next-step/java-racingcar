package racingcar.controller;

import racingcar.view.InputView;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Cars cars = inputView.enterCarNames();
        inputView.enterNumberOfGames(cars);

        RacingGame racingGame = new RacingGame();
        racingGame.findWinnerCar(cars.maxPosition(), cars.getCars());
        racingGame.printWinners();
    }
}
