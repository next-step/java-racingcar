package racingcar.domain;

import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private final int firstResultPoint;

    private Winner(int firstResultPoint) {
        this.firstResultPoint = firstResultPoint;
    }

    public static Winner of(int firstResultPoint) {
        return new Winner(firstResultPoint);
    }

    public static int resultPointOfFirst(List<Car> cars) {
        return cars.stream().map(Car::getMoveSpace)
                            .max(Integer::compareTo)
                            .get();
    }

    public int firstResultPoint() {
        return getFirstResultPoint();
    }

    private int getFirstResultPoint() {
        return firstResultPoint;
    }

    public List<Car> winnerSelection(List<Car> cars) {
        List<Car> winners = cars.stream()
                .filter(car -> car.getMoveSpace() == firstResultPoint())
                .collect(Collectors.toList());

        return winners;
    }
}
