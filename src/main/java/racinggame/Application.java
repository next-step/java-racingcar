package racinggame;

import racinggame.controller.RacingGameController;
import racinggame.domain.RacingCars;
import racinggame.domain.Trial;
import racinggame.view.InputView;

public class Application {

    public static void main(String[] args) {

        final RacingGameController controller = new RacingGameController(new InputView());

        while (true) {
            RacingCars racingCars = controller.getRacingCars();
            Trial trial = controller.getTrial();

            controller.startGame(racingCars, trial);
            controller.printResult();
            controller.printWinners(racingCars);
            controller.checkIsRestart();
        }
    }
}
