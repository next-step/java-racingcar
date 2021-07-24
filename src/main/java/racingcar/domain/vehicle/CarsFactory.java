package racingcar.domain.vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {

    private CarsFactory() {
    }

    public static Cars create(String carNameString) {
        List<Car> cars = Arrays.stream(carNameString.split(","))
            .map(CarFactory::create)
            .collect(Collectors.toList());

        return new Cars(cars);
    }
}
