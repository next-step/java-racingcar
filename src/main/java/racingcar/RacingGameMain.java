package racingcar;

import racingcar.game.RacingGame;
import racingcar.game.RacingGameResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameMain {
    public static void main(String[] args) {
        String nameValues = InputView.getCarNames();
        int round = InputView.getRound();

        RacingGame racingGame = RacingGame.newGame(nameValues, round);
        RacingGameResult racingGameResult = racingGame.go();

        OutputView.printResults(racingGameResult);
    }
}
