package racingcar;

import racingcar.domain.game.RacingGame;

import static racingcar.view.inputView.InputView.getCarNames;
import static racingcar.view.inputView.InputView.getRacingCounts;
import static racingcar.view.outputView.ResultView.*;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(getCarNames(), getRacingCounts());
        racingGame.start();
        printGameResult(racingGame);
    }
}
