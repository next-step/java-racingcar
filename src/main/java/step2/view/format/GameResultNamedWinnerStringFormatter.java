package step2.view.format;

import java.util.stream.Collectors;

import step2.domain.Car;
import step2.domain.GameResult;

public class GameResultNamedWinnerStringFormatter extends GameResultNamedStringFormatter {
    private static final String WINNER_MESSAGE = "이(가) 최종 우승했습니다.";

    public GameResultNamedWinnerStringFormatter() {
    }

    public GameResultNamedWinnerStringFormatter(final String carSymbol) {
        super(carSymbol);
    }

    @Override
    public String format(final GameResult gameResult) {
        return String.format("%s\n\n%s %s",
                             super.format(gameResult),
                             formatWinner(gameResult),
                             WINNER_MESSAGE);
    }

    private String formatWinner(final GameResult gameResult) {
        return gameResult.getWinners()
                         .stream()
                         .map(Car::getName)
                         .collect(Collectors.joining(", "));
    }
}
