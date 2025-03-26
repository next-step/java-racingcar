package racingcar;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.message.ErrorMessage.INVALID_NAME;
import static racingcar.message.Message.*;

public class Main {
    public static void main(String[] args) {

        final InputView inputView = new InputView();

        final List<String> names = getValidCarNames(inputView);
        final int attemptCount = getValidAttemptCount(inputView);

        final RacingGame racingGame = RacingGame.createRacingGame(names);

        final RacingGame finalResult = racingGame.race(attemptCount);

        final List<Car> winners = finalResult.getWinners();
        OutputView.printWinners(winners);
    }

    private static List<String> getValidCarNames(InputView inputView) {
        while (true) {
            try {
                inputView.printMessage(CAR_NAME_MESSAGE);
                return InputValidator.validateNames(inputView.readInput());

            } catch (IllegalArgumentException e) {
                OutputView.print(INVALID_NAME);
            }
        }
    }

    private static int getValidAttemptCount(InputView inputView) {
        inputView.printMessage(ATTEMPT_COUNT_MESSAGE);

        return InputValidator.validatePositiveNumber(inputView.readInput());
    }
}
