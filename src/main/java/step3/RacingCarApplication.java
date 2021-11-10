package step3;

import step3.domain.RacingGame;
import step3.view.InputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        String names = InputView.inputCarNames();
        int gameRoundCount = InputView.inputGameRoundCount();
        System.out.println();

        start(names, gameRoundCount);
    }

    private static void start(String names, int gameRoundCount) {
        RacingGame racingGame = RacingGame.create(gameRoundCount, names);
        racingGame.start();
    }
}
