package racingcar.model;

import racingcar.util.drivingStrategy.DrivingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

public class CarFactory {

    public static List<Car> generate(final int players) {
        return range(0, players)
                .mapToObj(Car::new)
                .collect(Collectors.toList());
    }

    public static List<Car> generate(final String[] names, final DrivingStrategy strategy) {
        return Arrays.stream(names)
                .map(name -> new Car(name, strategy))
                .collect(Collectors.toList());
    }

    public static List<Car> generate(final String[] names) {
        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
