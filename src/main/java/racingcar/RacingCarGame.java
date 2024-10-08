package racingcar;

import racingcar.model.CarManager;
import racingcar.model.Racing;
import racingcar.view.InputView;

public class RacingCarGame {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Racing racing = new Racing();

        CarManager carManager = racing.ready(InputView.inputCarName());

        racing.game(carManager, InputView.inputGameCount());
    }

}