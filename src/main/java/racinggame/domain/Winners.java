package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public List<String> carNames() {
        return winners.stream().map(Car::getName).toList();
    }

    public String joinWithComma() {
        return String.join(", ", carNames());
    }

    public static List<Car> findWinners(List<Car> cars) {
        return findWinners(cars, getMaxPosition(cars));
    }

    private static List<Car> findWinners(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isMaxPosition(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }
}
