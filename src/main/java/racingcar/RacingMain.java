package racingcar;

import racingcar.controller.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.dto.RacingResult;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingGame racingGame = new RacingGame(tryCount, carNames);
        RacingResult result = null;
        while (!racingGame.end()) {
            result = racingGame.race();
            OutputView.outputStatus(result);
        }
        OutputView.outputWinners(result);
    }
}
