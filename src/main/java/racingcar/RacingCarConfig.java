package racingcar;

import racingcar.domain.movement.BasicRule;
import racingcar.domain.movement.NumberGenerator;
import racingcar.domain.movement.RandomNumberGenerator;
import racingcar.domain.movement.Rule;
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

    public static Rule rule() {
        return new BasicRule();
    }

    public static NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }
}
