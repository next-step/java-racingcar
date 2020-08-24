package racingcar.domain.car;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static racingcar.utils.Constants.WINNER_NAMES_DELIMITER;
import static racingcar.domain.car.Cars.findWinners;
import static racingcar.utils.StringUtils.getNames;

public class WinnerCars {

    private final List<Car> winners;

    public WinnerCars(List<Car> winners) {
        this.winners = winners;
    }

    public static String getWinnersNames(List<Car> winners) {
        List<String> winnersNamesList = collectWinnerNames(winners);
        return getNames(winnersNamesList, WINNER_NAMES_DELIMITER);
    }

    private static List<String> collectWinnerNames(List<Car> winners) {
        return findWinners(winners).stream( )
                .map(o -> o.getCarName( ))
                .collect(Collectors.toList( ));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        WinnerCars winnerCars1 = (WinnerCars) o;
        return Objects.equals(winners, winnerCars1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
