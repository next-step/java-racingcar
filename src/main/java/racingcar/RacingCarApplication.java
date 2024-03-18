package racingcar;

import static racingcar.config.RacingCarConfig.inputView;
import static racingcar.config.RacingCarConfig.numberGenerator;
import static racingcar.config.RacingCarConfig.outputView;
import static racingcar.config.RacingCarConfig.resultFormatter;
import static racingcar.config.RacingCarConfig.rule;

import racingcar.controller.RacingGame;
import racingcar.domain.MovementStrategy;
import racingcar.view.RacingScreen;

public class RacingCarApplication {

    public static void main(String[] args) {
        final RacingScreen racingView = new RacingScreen(inputView(), outputView(), resultFormatter());
        final MovementStrategy movementStrategy = new MovementStrategy(rule(), numberGenerator());

        new RacingGame(racingView, movementStrategy).play();
    }
}
