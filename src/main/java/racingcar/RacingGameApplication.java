package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        System.out.println(carNames);
        System.out.println(tryCount);

        RacingGame racingGame = new RacingGame(carNames, tryCount);
        Cars raceResult = racingGame.race();

        ResultView.printResult(raceResult.getCars());

    }
}
