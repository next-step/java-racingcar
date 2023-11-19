package racingcar;

import racingcar.config.Configuration;
import racingcar.controller.RacingGameController;
import racingcar.domain.PositiveNumber;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        InputView inputView = configuration.inputView();

        PositiveNumber numberOfCars = inputView.numberOfCars();
        PositiveNumber numberOfAttempts = inputView.numberOfAttempts();

        RacingGameController controller = configuration.racingGameController();
        controller.run(numberOfCars, numberOfAttempts);
    }
}
