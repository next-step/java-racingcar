package racingcar;


import racingcar.controller.RacingController;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(String[] args) {
        RacingGame racingGame = RacingGame.from(Cars.instance());
        RacingController racingController = new RacingController(racingGame,
            InputView.instance(), ResultView.instance());
        racingController.run();
    }

}
