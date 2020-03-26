package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.RandomMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGame game = new RacingGame(InputView.getInputData(), new RandomMoveStrategy());

        ResultView.printGameResult();

        while (!game.isFinish()) {
            game.progress();

            ResultView.renderCarMovement(game.getCars());
        }
        ResultView.printWinners(game.getCars());
    }
}
