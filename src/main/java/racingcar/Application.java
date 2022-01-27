package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        RacingCarGame racingCarGame = new RacingCarGame(inputView.getTryCount(),
            inputView.getCarNames());

        racingCarGame.play();
    }
}
