package racingcar;

import racingcar.contoller.RacingCarController;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        new RacingCarController(new RacingGame(), new InputView().input()).startGame();
    }
}
