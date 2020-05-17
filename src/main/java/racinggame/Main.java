package racinggame;

import racinggame.game.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.inputCarNames();
        int round = InputView.inputRound();

        RacingGame racingGame = new RacingGame(carNames);

        ResultView.showTitle();

        for (int i = 0; i < round; i++) {
            ResultView.showCarPositions(racingGame.start());
        }

        ResultView.showWinnerMessage(racingGame.getWinnerCarNames());
    }
}
