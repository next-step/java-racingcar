package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarGenerator {

    public static List<Car> createCars(int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }
}
