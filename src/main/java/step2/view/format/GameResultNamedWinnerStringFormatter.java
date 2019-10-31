package step2.view.format;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import step2.domain.GameResult;
import step2.domain.Car;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

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
        List<Car> winnerCars = gameResult.getPhase(gameResult.getNumberOfPhases() - 1)
                                         .getAllCars()
                                         .stream()
                                         .collect(toMap(Car::current,
                                                        Arrays::asList,
                                                        (l1, l2) -> Stream.concat(l1.stream(), l2.stream())
                                                                          .collect(toList()),
                                                        TreeMap::new))
                                         .lastEntry()
                                         .getValue();

        return winnerCars.stream()
                         .map(Car::getName)
                         .collect(Collectors.joining(", "));
    }
}
