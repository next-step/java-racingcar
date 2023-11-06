package racingcar;

import racingcar.config.Configuration;
import racingcar.controller.RacingGameController;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        InputView inputView = configuration.inputView();

        int numberOfCars = inputView.numberOfCars();
        int numberOfAttempts = inputView.numberOfAttempts();

        RacingGameController controller = configuration.racingGameController();
        controller.run(numberOfCars, numberOfAttempts);
    }
}
