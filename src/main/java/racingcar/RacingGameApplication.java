package racingcar;

import racingcar.domain.RacingGame;

import java.util.List;

import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputTrial;
import static racingcar.view.ResultView.printGameResult;

public class RacingGameApplication {
    public static void main(String[] args) {
        List<String> carNames = parseCarNames(inputCarNames());
        int trial = inputTrial();

        RacingGame racingGame = new RacingGame();
        racingGame.startGame(carNames, trial);
        printGameResult(racingGame.getRoundResults());
    }

    public static List<String> parseCarNames(String carNamesString) {
        return List.of(carNamesString.split(","));
    }
}
