package racingcar.domain.car;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static racingcar.utils.Constants.WINNER_CAR_NAMES_DELIMITER;
import static racingcar.domain.car.Cars.findWinners;
import static racingcar.utils.StringUtils.getNames;

public class WinnerCars {

    private final List<Car> winnerCars;

    public WinnerCars(List<Car> winnerCars) {
        this.winnerCars = winnerCars;
    }

    public static String getWinnersNames(List<Car> winnerCars) {
        List<String> winnerCarsNamesList = collectWinnerCarsNames(winnerCars);
        return getNames(winnerCarsNamesList, WINNER_CAR_NAMES_DELIMITER);
    }

    private static List<String> collectWinnerCarsNames(List<Car> winnerCars) {
        return findWinners(winnerCars).stream( )
                .map(o -> o.getCarName( ))
                .collect(Collectors.toList( ));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        WinnerCars winnerCars1 = (WinnerCars) o;
        return Objects.equals(winnerCars, winnerCars1.winnerCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerCars);
    }
}
