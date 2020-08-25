package racingcar.domain.car;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static racingcar.utils.Constants.WINNER_CAR_NAMES_DELIMITER;
import static racingcar.utils.StringUtils.getNames;

public class WinnerCars {

    private final List<Car> winnerCars;

    public WinnerCars(List<Car> winnerCars) {
        this.winnerCars = winnerCars;
    }

    public String getWinnersNames() {
        Cars winners = new Cars(winnerCars);
        List<String> winnerCarsNamesList = winners.findWinners().stream( )
                .map(winner -> winner.getCarName())
                .collect(Collectors.toList());
        return getNames(winnerCarsNamesList, WINNER_CAR_NAMES_DELIMITER);
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
