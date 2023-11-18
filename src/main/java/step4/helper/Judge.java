package step4.helper;

import step4.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    private Judge() {}

    public static List<Car> judgeWinners(List<Car> cars) {
        int maxForwardCount = getMaxForwardCount(cars);
        return getMaxForwardCountCar(cars, maxForwardCount);
    }

    private static int getMaxForwardCount(List<Car> cars) {
        int value = 0;
        for (Car car : cars) {
            value = car.graterThanForwardCount(value);
        }
        return value;
    }

    private static List<Car> getMaxForwardCountCar(List<Car> cars, int value) {
        return cars.stream()
                .filter((car) -> car.equalForwardCount(value))
                .collect(Collectors.toList());
    }
}
