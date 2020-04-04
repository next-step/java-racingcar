package racinggame.controller;

import racinggame.domain.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingGameApp {

    public static void main(String[] args) {

        String[] carNames = InputView.cars();
        int roundNumber = InputView.rounds();

        RacingGame racingGame = new RacingGame(carNames, roundNumber);

        ResultView.printResult(racingGame.allRounds());
        ResultView.printWinner(racingGame.findWinners());
    }
}
