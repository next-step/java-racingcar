package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResults;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame(inputView.getTime(), inputView.getCarNames());
        RacingGameResults gameResults = racingGame.game();

        ResultView resultView = new ResultView();
        resultView.print(gameResults);
    }

}
