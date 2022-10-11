package racingcar;

import racingcar.domain.RacingGame;

import java.util.List;
import java.util.NoSuchElementException;

import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputTrial;
import static racingcar.view.ResultView.printGameResult;
import static racingcar.view.ResultView.printWinners;

public class RacingGameApplication {
    public static void main(String[] args) {
        List<String> carNames = parseCarNames(inputCarNames());
        int trial = inputTrial();

        RacingGame racingGame = new RacingGame();
        startGame(carNames, trial, racingGame);
        printGameResult(racingGame.getRoundResults());
        printWinners(getWinners(racingGame));
    }

    private static void startGame(List<String> carNames, int trial, RacingGame racingGame) {
        try {
            racingGame.startGame(carNames, trial);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<String> getWinners(RacingGame racingGame) {
        try {
            return racingGame.getWinners();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<String> parseCarNames(String carNamesString) {
        return List.of(carNamesString.split(","));
    }
}
