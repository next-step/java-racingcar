package racingcar.car;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarCreator {

    private CarCreator() {}

    public static List<Car> create(int count) {
        return Stream.generate(Car::new).limit(count).collect(Collectors.toList());
    }
}