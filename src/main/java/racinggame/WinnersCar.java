package racinggame;

import java.util.List;
import java.util.stream.Collectors;

public class WinnersCar {
    private static final int WINNER_MIN_LOCATION = 0;

    public List<Car> racingWinner(List<Car> cars) {
        int winnerLocation = getWinnerLocation(cars);
        return cars.stream()
                .filter(car -> car.getLocation() == winnerLocation)
                .collect(Collectors.toUnmodifiableList());
    }

    private static int getWinnerLocation(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .reduce(WINNER_MIN_LOCATION, Math::max);
    }

}
