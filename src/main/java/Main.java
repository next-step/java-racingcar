import racingcar.model.RacingGame;
import racingcar.util.InputValidator;
import racingcar.view.InputView;

import static racingcar.message.Message.*;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.printMessage(CAR_COUNT_MESSAGE);
        int carCount = InputValidator.validatePositiveNumber(inputView.readInput());

        inputView.printMessage(ATTEMPT_COUNT_MESSAGE);
        int attemptCount = InputValidator.validatePositiveNumber(inputView.readInput());

        RacingGame racingGame = new RacingGame(carCount);
        racingGame.race(attemptCount);
    }
}
