package racingcar;

import racingcar.domain.CarPositions;
import racingcar.domain.RacingGame;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame(inputView.getTime(), inputView.getTotalCarCount());

        CarPositions gameResult = racingGame.game();
        ResultView resultView = new ResultView(gameResult.getResult());
        resultView.print();
    }

}
