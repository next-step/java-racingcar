package step3.factory;

import step3.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static Car create(String name) {
        return new Car(name);
    }

    public static List<Car> creates(String[] names) {
        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private CarFactory() {
        throw new AssertionError();
    }

}
