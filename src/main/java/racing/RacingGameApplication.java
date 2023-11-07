package racing;

import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        int carCount = InputView.generateCarCountQuestion();
        int gameCount = InputView.generateGameCountQuestion();

        RacingGame racingGame = new RacingGame(carCount, gameCount);

        while (racingGame.isProgress()) {
            racingGame.doRacing();
            ResultView.getProgress(racingGame);
        }

    }
}
