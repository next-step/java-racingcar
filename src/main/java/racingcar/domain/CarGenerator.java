package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {

    public static List<Car> generateCars(ArrayList<String> carNames) {
        return carNames
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
