package racingCar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    private Referee() {}

    public static List<Car> findWinners(List<Car> cars) {
        return findSameDistanceCars(cars, findMaxDistance(cars));
    }

    private static Distance findMaxDistance(List<Car> cars) {
        Distance maxDistance = new Distance();
        for (Car car : cars) {
            maxDistance = maxDistance.max(car.distance());
        }
        return maxDistance;
    }

    private static List<Car> findSameDistanceCars(List<Car> cars, Distance distance) {
        return cars.stream().filter(car -> car.distance().equals(distance)).collect(Collectors.toList());
    }
}