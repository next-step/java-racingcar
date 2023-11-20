package racingcar;

import java.util.List;
import racingcar.config.Configuration;
import racingcar.controller.RacingGameController;
import racingcar.domain.PositiveNumber;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        InputView inputView = configuration.inputView();

        List<String> carNames = inputView.carNames();
        PositiveNumber numberOfAttempts = inputView.numberOfAttempts();

        RacingGameController controller = configuration.racingGameController();
        controller.run(carNames, numberOfAttempts);
    }
}
