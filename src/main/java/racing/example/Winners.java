package racing.example;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    public static List<Car> findWinners(List<Car> cars) {
        return findWinners(cars, maxPosition(cars));
    }

    private static List<Car> findWinners(List<Car> cars, int maxPosition) {
        return cars
                .stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

    private static int maxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }

        return maxPosition;
    }
}
