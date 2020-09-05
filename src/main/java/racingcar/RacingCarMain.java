package racingcar;

import racingcar.domain.RacingGame;

import static racingcar.view.InputView.getCarNames;
import static racingcar.view.InputView.getRacingCounts;
import static racingcar.view.ResultView.*;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(getCarNames(), getRacingCounts());
        racingGame.start();
        printGameResult(racingGame);
    }
}
