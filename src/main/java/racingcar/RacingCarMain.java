package racingcar;

import racingcar.view.InputView;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.readCarCount();
        int attemptCount = inputView.readAttemptCount();

        RacingCarGame racingCarGame = new RacingCarGame(carCount, attemptCount);
        racingCarGame.start();
    }
}
