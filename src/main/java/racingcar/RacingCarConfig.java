package racingcar;

import racingcar.domain.movement.BasicMovingStrategy;
import racingcar.domain.movement.MovingStrategy;
import racingcar.domain.movement.NumberGenerator;
import racingcar.domain.movement.RandomNumberGenerator;
import racingcar.view.RacingScreen;
import racingcar.view.RacingView;
import racingcar.view.io.Input;
import racingcar.view.io.Output;
import racingcar.view.io.console.ConsoleInput;
import racingcar.view.io.console.ConsoleOutput;

public final class RacingCarConfig {

    private RacingCarConfig() {
    }

    public static RacingView racingView() {
        return new RacingScreen(inputView(), outputView());
    }

    private static Input inputView() {
        return new ConsoleInput();
    }

    private static Output outputView() {
        return new ConsoleOutput();
    }

    public static MovingStrategy movingStrategy() {
        return new BasicMovingStrategy();
    }

    public static NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }
}
