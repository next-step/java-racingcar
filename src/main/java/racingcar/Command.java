package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public enum Command {
    FORWARD(Car::forward,
        Arrays.asList(
            number -> number >= 4,
            number -> number < 10)),

    NON_FORWARD(Car::nonForward,
        Arrays.asList(
            number -> number >= 0,
            number -> number < 4));

    private final Consumer<Car> parser;
    private final List<Predicate<Integer>> options;


    Command(Consumer<Car> parser,
        List<Predicate<Integer>> options) {
        this.parser = parser;
        this.options = options;

    }


    public static Consumer<Car> of(int commandNumber) {
        return Arrays.stream(values())
            .filter(cmd -> cmd.options.parallelStream()
                .allMatch(flag -> flag.test(commandNumber)))
            .findFirst()
            .map(Command::getParser)
            .orElseThrow(() -> new IllegalArgumentException("입력 값은 0~9가 와야합니다."));
    }

    public Consumer<Car> getParser() {
        return parser;
    }
}
