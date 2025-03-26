package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.Movement;
import racingcar.domain.NumberGenerator;
import racingcar.domain.NumberOverFourMovement;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Movement numberOverFour = new NumberOverFourMovement(randomNumberGenerator);

        new RacingController(
                new InputView(),
                new OutputView(),
                numberOverFour
        ).run();
    }
}
