package racingcarfinal.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String name) {
        this.cars = Arrays.stream(name.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> findWinners() {
        return findWinners(cars);
    }

    public static List<Car> findWinners(List<Car> cars) {
        int max = cars.stream()
                .mapToInt(car -> car.getPosition().getIntValue())
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getPosition().getIntValue() == max)
                .collect(Collectors.toList());
    }

}
