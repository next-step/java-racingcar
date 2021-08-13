package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        RacingGame racingGame = new RacingGame(inputView.inputCar(), inputView.inputAttempt());

        racingGame.startGame();
    }

}
