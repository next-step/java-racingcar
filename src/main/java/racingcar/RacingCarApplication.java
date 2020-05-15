package racingcar;

import racingcar.domain.game.GameInfo;
import racingcar.domain.game.GameResult;
import racingcar.domain.game.RacingGame;
import racingcar.domain.car.strategy.RandomMovementStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        GameInfo gameInfo = InputView.inputGameInfo();

        RacingGame racingGame = new RacingGame(gameInfo);

        racingGame.startGame(new RandomMovementStrategy());

        GameResult gameResult = racingGame.getGameResult();

        OutputView.printGameResult(gameResult);
    }
}
