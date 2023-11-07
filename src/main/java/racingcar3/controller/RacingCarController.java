package racingcar3.controller;

import racingcar3.model.RacingGame;
import racingcar3.view.InputView;
import racingcar3.view.ResultView;

public class RacingCarController {
    public static void main(String[] args) {
        int numberOfCars = InputView.promptNumberOfCars();
        int count = InputView.promptCount();

        RacingGame game = new RacingGame(numberOfCars);
        System.out.println("\n실행 결과");
        ResultView.playGame(game);
        for (int i = 0; i < count; i++) {
            game.oneTurn();
            ResultView.playGame(game);
        }
    }
}
