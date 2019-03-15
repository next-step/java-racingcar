package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    public static List<Car> getWinner(List<Car> cars) {
        int maxPosition = getMaxPositionFromCars(cars);

        List<Car> winners = cars.stream()
                .filter(car -> car.isEqualPosition(maxPosition))
                .collect(Collectors.toList());

        return winners;
    }

    public static int getMaxPositionFromCars(List<Car> cars) {

        return cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElse(cars.get(0).getPosition());
    }
}
