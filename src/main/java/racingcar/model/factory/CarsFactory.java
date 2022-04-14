package racingcar.model.factory;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {
    private static final String CAR_NAME_DELIMITER = ",";

    public static Cars create(String carNames) {
        return new Cars(toCars(split(carNames)));
    }

    private static String[] split(String carNames) {
        return carNames.split(CAR_NAME_DELIMITER);
    }

    private static List<Car> toCars(String[] carNameStrings) {
        return Arrays.stream(carNameStrings)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
