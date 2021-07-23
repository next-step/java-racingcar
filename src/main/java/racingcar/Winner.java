package racingcar;

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

    public int firstResultPoint() {
        return getFirstResultPoint();
    }

    private int getFirstResultPoint() {
        return firstResultPoint;
    }

    public void extracted(ResultView resultView, List<Car> cars, Winner winner) {
        List<Car> winners = cars.stream()
                .filter(car -> car.getMoveSpace() == winner.firstResultPoint())
                .collect(Collectors.toList());

        resultView.getWinner(winners);
    }

    public static int resultPointOfFirst(List<Car> cars) {
        return cars.stream().map(Car::getMoveSpace)
                            .max(Integer::compareTo)
                            .get();
    }
}
