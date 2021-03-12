package racingcar;

import racingcar.contoller.RacingCarController;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    private static RacingCarController racingCarController = new RacingCarController(new RacingGame());

    public static void main(String[] args) {
        racingCarController.startGame();
    }
}
