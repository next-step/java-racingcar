package racingcar4.controller;

import racingcar4.model.RacingGame;
import racingcar4.view.InputView;
import racingcar4.view.ResultView;

public class RacingCarController {
    public static void main(String[] args) {
        String nameOfCars = InputView.promptNameOfCars();
        int count = InputView.promptCount();

        RacingGame game = new RacingGame(nameOfCars);
        ResultView.startGame();
        for (int i = 0; i < count; i++) {
            game.oneTurn();
            ResultView.printOneTurn(game);
        }

        ResultView.printVictoryCars(game);
    }
}
