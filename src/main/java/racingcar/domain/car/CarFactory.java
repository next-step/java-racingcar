package racingcar.domain.car;

import racingcar.domain.game.utils.CarNameValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.domain.game.utils.Constants.INPUT_DELIMITER;

public class CarFactory {

    public static List<Car> createCars(String value) {
        String[] values = value.split(INPUT_DELIMITER);
        List<Car> newCars = collectCreateCars(values);
        return newCars;
    }

    private static List<Car> collectCreateCars(String[] values) {
        return Arrays.stream(values)
                .map(CarNameValidation::checkName)
                .map(Car::new)
                .collect(Collectors.toList( ));
    }

}
