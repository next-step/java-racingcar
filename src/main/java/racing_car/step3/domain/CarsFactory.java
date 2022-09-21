package racing_car.step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarsFactory {
    public static List<Car> from(int numberOfCars) {
        return IntStream.range(0, numberOfCars)
                .mapToObj(count -> new Car(0))
                .collect(Collectors.toList());
    }
}
