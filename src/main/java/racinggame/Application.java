package racinggame;

import java.util.List;
import racinggame.controller.RacingGameController;
import racinggame.domain.RacingCar;
import racinggame.domain.Trial;
import racinggame.service.InputService;
import racinggame.view.InputView;

public class Application {

    public static void main(String[] args) {

        RacingGameController controller = new RacingGameController(new InputView(), new InputService());

        while (true) {
            List<RacingCar> racingCars = controller.getRacingCars();
            Trial trial = controller.getTrial();

            controller.startGame(racingCars, trial);
            controller.printResult();
            controller.printWinners(racingCars);
            controller.checkIsRestart();
        }
    }
}
