package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    public static List<String> award(RacingCars racingCars) {
        return getWinnerNames(racingCars.getWinnerCars());
    }

    private static List<String> getWinnerNames(List<Car> winnerCars) {
        return winnerCars
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
