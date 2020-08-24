package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.utils.Constants.INPUT_DELIMITER;
import static racingcar.utils.CarNameValidation.isValid;

public class CarFactory {

    public static List<Car> createCars(String value) {
        String[] values = value.split(INPUT_DELIMITER);
        List<Car> newCars = collectCreateCars(values);
        return newCars;
    }

    private static List<Car> collectCreateCars(String[] values) {
        return Arrays.stream(values)
                .filter(o -> isValid(o))
                .map(o -> new Car(o))
                .collect(Collectors.toList( ));
    }

}
