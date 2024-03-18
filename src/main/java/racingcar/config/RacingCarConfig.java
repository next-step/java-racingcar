package racingcar.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import racingcar.domain.movement.BasicRule;
import racingcar.domain.movement.NumberGenerator;
import racingcar.domain.movement.RandomNumberGenerator;
import racingcar.domain.movement.Rule;
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

    public static Input inputView() {
        return (Input)container.computeIfAbsent(Input.class, k -> new ConsoleInput());
    }

    public static Output outputView() {
        return (Output)container.computeIfAbsent(Output.class, k -> new ConsoleOutput());
    }

    public static ResultFormatter resultFormatter() {
        return (ResultFormatter)container.computeIfAbsent(ResultFormatter.class, k -> new ConsoleResultFormatter());
    }

    public static Rule rule() {
        return (Rule)container.computeIfAbsent(Rule.class, k -> new BasicRule());
    }

    public static NumberGenerator numberGenerator() {
        return (NumberGenerator)container.computeIfAbsent(NumberGenerator.class, k -> new RandomNumberGenerator());
    }
}
