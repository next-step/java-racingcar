package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    public static List<Car> findWinners(List<Car> cars) {
        return findWinners(cars, getMaxPosition(cars));
    }

    private static List<Car> findWinners(List<Car> cars, int maxPosition) {
        return cars.stream().filter(car -> car.getCurrentPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(0);
    }
}
