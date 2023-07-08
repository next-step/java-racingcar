package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.ConsoleRacingCarView;
import racingcar.view.RacingCarView;

public class RacingGameApplication {
    public static void main(String[] args) {
        RacingCarView view = new ConsoleRacingCarView();
        RacingGameController controller = new RacingGameController(view);

        String carNames = controller.readCarNames();
        String count = controller.readCount();

        controller.playGame(carNames, count);
    }
}
