package racinggame;

import racinggame.controller.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int numOfTrial = InputView.getNumOfTrial();

        RacingGame racingGame = new RacingGame(carNames, numOfTrial);
        ResultView.printResultMessage();
        racingGame.race();
        ResultView.printWinner(racingGame.getWinners());
    }
}
