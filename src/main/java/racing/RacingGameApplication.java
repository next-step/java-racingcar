package racing;

import racing.domain.RacingGame;
import racing.view.InputView;

public class RacingGameApplication {

    public static void main(String[] args) {
        int carCount = InputView.generateCarCountQuestion();
        int gameCount = InputView.generateGameCountQuestion();

        RacingGame racingGame = new RacingGame(carCount, gameCount);
        racingGame.doRacing();
    }
}
