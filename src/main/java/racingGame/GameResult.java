package racingGame;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    public static List<Car> getWinners(List<Car> cars) {
        int maxPosition = getMaxPositionOfCars(cars);
        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .collect(Collectors.toList());
    }

    private static int getMaxPositionOfCars(List<Car> cars) {
        return Collections.max(cars).getCurrentPosition();
    }
}
