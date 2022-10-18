package racingcar;

import racingcar.domain.RacingGame;
import racingcar.dto.GameResultDto;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputTrial;
import static racingcar.view.ResultView.printGameResult;
import static racingcar.view.ResultView.printWinners;

public class RacingGameApplication {
    public static void main(String[] args) {
        List<String> carNames = parseCarNames(inputCarNames());
        int trial = inputTrial();

        RacingGame racingGame = new RacingGame();
        GameResultDto racingGameResult = doGame(carNames, trial, racingGame);
        Objects.requireNonNull(racingGameResult);
        printGameResult(racingGameResult);
        printWinners(racingGameResult.winnerNames);
    }

    private static GameResultDto doGame(List<String> carNames, int trial, RacingGame racingGame) {
        try {
            return racingGame.doGame(carNames, trial);
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<String> parseCarNames(String carNamesString) {
        return List.of(carNamesString.split(","));
    }
}
