package racingGame.controller;

import racingGame.view.InputView;
import racingGame.domain.RacingGame;
import racingGame.view.ResultView;

public class RacingGameApp {

    public static void main(String[] args) {

        String[] carNames = InputView.cars();
        int roundNumber = InputView.rounds();

        RacingGame racingGame = new RacingGame(carNames);

        for (int round = 0; round < roundNumber; round++) {
            ResultView.printResult(racingGame.racing());
        }
        ResultView.printWinner(racingGame.findWinners());
    }
}
