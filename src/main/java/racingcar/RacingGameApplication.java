package racingcar;

import racingcar.domain.RacingGame;
import racingcar.dto.GameResultDto;

import java.util.List;
import java.util.NoSuchElementException;

import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputTrial;
import static racingcar.view.ResultView.printGameResult;
import static racingcar.view.ResultView.printWinners;

public class RacingGameApplication {
    private static final String UNEXPECTED_TERMINATION_EXCEPTION = "예상치 못한 오류로 게임이 종료됩니다.";

    public static void main(String[] args) {
        List<String> carNames = parseCarNames(inputCarNames());
        int trial = inputTrial();

        RacingGame racingGame = new RacingGame();
        GameResultDto racingGameResult = doGame(carNames, trial, racingGame);
        printGameResult(racingGameResult);
        printWinners(racingGameResult.winnerNames);
    }

    private static GameResultDto doGame(List<String> carNames, int trial, RacingGame racingGame)
            throws RuntimeException {
        try {
            return racingGame.doGame(carNames, trial);
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        throw new RuntimeException(UNEXPECTED_TERMINATION_EXCEPTION);
    }

    public static List<String> parseCarNames(String carNamesString) {
        return List.of(carNamesString.split(","));
    }
}
