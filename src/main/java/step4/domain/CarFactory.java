package step4.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static Cars createCars(CarNames carNames) {
        List<Car> cars = carNames.getNames().stream().map(Car::new).collect(Collectors.toList());
        return new Cars(cars);
    }
}
