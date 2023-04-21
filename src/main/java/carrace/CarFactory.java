package carrace;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarFactory {
    public static List<Car> createCars(int num) {
        return Stream.generate(Car::new).limit(num).collect(Collectors.toList());
    }
}
