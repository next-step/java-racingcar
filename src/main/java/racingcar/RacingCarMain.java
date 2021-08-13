package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputCar(), InputView.inputAttempt());

        racingGame.startGame();
    }

}
