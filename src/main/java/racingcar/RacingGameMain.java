package racingcar;

import racingcar.game.RacingGame;
import racingcar.game.Results;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameMain {
    public static void main(String[] args) {
        int count = InputView.getCountOfCars();
        int round = InputView.getRound();

        RacingGame racingGame = RacingGame.newGame(count, round);
        Results results = racingGame.go();

        OutputView.printResults(results);
    }
}
