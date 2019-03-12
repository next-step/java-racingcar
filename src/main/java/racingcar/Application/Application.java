package racingcar.Application;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame(inputView.setCarCount(), inputView.setRound());
        racingGame.play();
    }
}
