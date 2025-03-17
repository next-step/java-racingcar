import racingcar.model.RacingGame;
import racingcar.view.InputView;

import static racingcar.message.Message.*;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.printMessage(CAR_COUNT_MESSAGE);
        int carCount = inputView.convertToInt(inputView.readInput());

        inputView.printMessage(ATTEMPT_COUNT_MESSAGE);
        int attemptCount = inputView.convertToInt(inputView.readInput());

        RacingGame racingGame = new RacingGame(carCount);
        racingGame.race(attemptCount);
    }
}
