package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    public static List<Car> find(List<Car> cars) {
        int position = winnerPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .collect(Collectors.toList());
    }

    private static int winnerPosition(List<Car> cars) {
        int max = 0;
        for (Car car: cars) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }
}
