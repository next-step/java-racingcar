package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static String[] split(String str) {
        return str.split(",");
    }

    public void takeTurn() {
        for (Car car : cars) {
            car.progress();
        }
    }

    public List<String> findWinnerNames() {
        int maxDistance = findMaxCarDistance();
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxCarDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
