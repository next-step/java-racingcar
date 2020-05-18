package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static List<Car> create(String[] names) {
        return Arrays.stream(names)
                .map(CarFactory::create)
                .collect(Collectors.toList());
    }

    public static Car create(String name) {
        return new Car(name);
    }
}
