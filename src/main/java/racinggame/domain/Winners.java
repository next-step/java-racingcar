package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        validate(winners);
        this.winners = winners;
    }

    private static void validate(List<Car> winners) {
        if (winners == null || winners.isEmpty()) {
            throw new IllegalArgumentException("우승자는 최소 한명 이상이어야 합니다.");
        }
    }

    public List<String> carNames() {
        return winners.stream().map(Car::getName).toList();
    }

    public String joinWithComma() {
        return String.join(", ", carNames());
    }

    public int size() {
        return winners.size();
    }

    public boolean contains(Car car) {
        return winners.contains(car);
    }

    public static Winners findWinners(List<Car> cars) {
        return new Winners(findWinners(cars, getMaxPosition(cars)));
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
