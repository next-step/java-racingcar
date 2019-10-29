package step2;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class GameResultStringFormatter implements GameResultFormatter<String> {
    private static final String DEFAULT_CAR_SYMBOL = "-";
    private static final String DEFAULT_END_OF_LINE = "\n";
    private static final String EMTPY = "";

    private final String carSymbol;

    public GameResultStringFormatter() {
        this.carSymbol = DEFAULT_CAR_SYMBOL;
    }

    public GameResultStringFormatter(final String carSymbol) {
        this.carSymbol = carSymbol;
    }

    @Override
    public String format(final GameResult gameResult) {
        return gameResult.getAllPhase().stream()
                         .map(this::formatPhase)
                         .collect(joining(DEFAULT_END_OF_LINE + DEFAULT_END_OF_LINE));
    }

    private String formatPhase(final GameResult.Phase phase) {
        return phase.getAllCars().stream()
                    .map(this::formatCar)
                    .collect(joining(DEFAULT_END_OF_LINE));
    }

    private String formatCar(final Car car) {
        return IntStream.range(0, car.current())
                        .mapToObj(i -> carSymbol)
                        .reduce(EMTPY, (acc, cur) -> acc + cur);
    }
}
