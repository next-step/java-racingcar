package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameRunner {
    public static void main(String[] args) {
        int numberOfCars = InputView.promptNumberOfCars();
        int count = InputView.promptCount();

        RacingGame game = new RacingGame(numberOfCars);
        ResultView.renderCars(game, count);
    }
}