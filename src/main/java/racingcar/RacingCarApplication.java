package racingcar;

import racingcar.domain.game.GameInfo;
import racingcar.domain.game.GameResult;
import racingcar.domain.game.RacingGame;
import racingcar.domain.car.power.RandomPower;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        int numberOfCar = InputView.inputNumberOfCar();
        int numberOfPhase = InputView.inputNumberOfPhase();

        GameInfo gameInfo = new GameInfo(numberOfCar, numberOfPhase);

        RacingGame racingGame = new RacingGame(gameInfo);

        racingGame.startGame(new RandomPower());

        GameResult gameResult = racingGame.getGameResult();

        OutputView.printGameResult(gameResult);
    }
}
