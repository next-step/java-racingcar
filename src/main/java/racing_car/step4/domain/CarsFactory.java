package racing_car.step4.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {
    public static List<Car> from(String[] carsName) {
        return Arrays.stream(carsName)
                .map(carName -> new Car(new CarName(carName)))
                .collect(Collectors.toList());
    }
}
