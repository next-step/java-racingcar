package racinggame.domain.car;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.exception.InvalidCarRegistrationException;

public class CarsInitializer {

    public static final String DELIMITER = ",";

    public static Cars initCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] carNameArray = splitCarNames(carNames);

        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }

    private static String[] splitCarNames(String carNames) {
        validateCarNamesNull(carNames);
        return carNames.split(DELIMITER);
    }

    private static void validateCarNamesNull(String carNames) {
        if (carNames == null) {
            throw new InvalidCarRegistrationException();
        }
    }

}
