package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {

    public static List<Car> genearteCarList(String inputNames) {
        return Arrays
                .stream(inputNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
