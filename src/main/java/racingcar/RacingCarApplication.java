package racingcar;

import racingcar.domain.GameInfo;
import racingcar.domain.GameResult;
import racingcar.domain.RacingGame;
import racingcar.domain.car.RandomNumberGenerator;
import racingcar.dto.InputValueDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        int numberOfCar = InputView.inputNumberOfCar();
        int numberOfPhase = InputView.inputNumberOfPhase();

        GameInfo gameInfo = new GameInfo(numberOfCar, numberOfPhase);

        RacingGame racingGame = new RacingGame(gameInfo);

        racingGame.startGame(new RandomNumberGenerator());

        GameResult gameResult = racingGame.getGameResult();

        OutputView.printGameResult(gameResult);
    }
}
