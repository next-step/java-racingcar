package step3.game;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    public static List<String> findWinners(List<GameRound> cars) {
        List<Car> finalRound = cars.get(cars.size() - 1).getRound();
        return filterWinners(finalRound, findMaxPosition(finalRound));
    }

    private static List<String> filterWinners(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }
}
