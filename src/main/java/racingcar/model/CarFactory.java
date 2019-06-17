package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

public class CarFactory {

    public static List<Car> generate(int players) {
        return range(0, players)
                .mapToObj(Car::new)
                .collect(Collectors.toList());
    }
}
