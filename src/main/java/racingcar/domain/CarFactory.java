package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.utils.CarNameValidation.isValid;

public class CarFactory {

    public static final String INPUT_DELIMITER = ",";

    public static List<Car> createCars(String value) {
        String[] values = value.split(INPUT_DELIMITER);
        List<Car> newCars = Arrays.stream(values)
                                .filter(o -> isValid(o))
                                .map(o -> new Car(o.trim()))
                                .collect(Collectors.toList( ));
        return newCars;
    }

}
