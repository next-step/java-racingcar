package racingcar.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import racingcar.controller.RacingGame;
import racingcar.domain.movement.BasicRule;
import racingcar.domain.movement.MovementStrategy;
import racingcar.domain.movement.NumberGenerator;
import racingcar.domain.movement.RandomNumberGenerator;
import racingcar.domain.movement.Rule;
import racingcar.view.RacingScreen;
import racingcar.view.RacingView;
import racingcar.view.io.Input;
import racingcar.view.io.Output;
import racingcar.view.io.console.ConsoleInput;
import racingcar.view.io.console.ConsoleOutput;
import racingcar.view.util.ConsoleResultFormatter;
import racingcar.view.util.ResultFormatter;

public final class RacingCarConfig {

    private static final Map<Class<?>, Object> container = new ConcurrentHashMap<>();

    private RacingCarConfig() {
    }

    public static RacingGame racingGame() {
        return (RacingGame)container.computeIfAbsent(RacingGame.class, k -> new RacingGame(racingView()));
    }

    private static RacingView racingView() {
        return new RacingScreen(inputView(), outputView(), resultFormatter());
    }

    private static Input inputView() {
        return new ConsoleInput();
    }

    private static Output outputView() {
        return new ConsoleOutput();
    }

    private static ResultFormatter resultFormatter() {
        return new ConsoleResultFormatter();
    }

    public static MovementStrategy movementStrategy() {
        return (MovementStrategy)container.computeIfAbsent(MovementStrategy.class,
                k -> new MovementStrategy(rule(), numberGenerator()));
    }

    private static Rule rule() {
        return new BasicRule();
    }

    private static NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }
}
