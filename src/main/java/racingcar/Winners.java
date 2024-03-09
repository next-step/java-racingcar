package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners from(List<Car> cars) {
        List<Car> winners = selectWinners(cars);
        return new Winners(winners);
    }

    private static List<Car> selectWinners(List<Car> cars) {
        int maxDistance = maxDistance(cars);
        return cars.stream()
            .filter(car -> car.matchDistance(maxDistance))
            .collect(Collectors.toList());
    }

    private static int maxDistance(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::drivingDistance)
            .max()
            .orElseThrow(IllegalStateException::new);
    }

    public List<String> names() {
        return winners.stream()
            .map(Car::name)
            .collect(Collectors.toList());
    }
}
