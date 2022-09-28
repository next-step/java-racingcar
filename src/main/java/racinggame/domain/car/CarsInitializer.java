package racinggame.domain.car;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.exception.InvalidCarRegistrationException;

public class CarsInitializer {

    public static final String DELIMITER = ",";

    public static Cars initCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] carNameArray = getCarNameArray(carNames);

        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }

    private static String[] getCarNameArray(String carNames) {
        String[] carNameArray = splitCarNames(carNames);
        validateCarCount(carNameArray);

        return carNameArray;
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

    private static void validateCarCount(String[] carNameArray) {
        if (carNameArray.length == 0) {
            throw new InvalidCarRegistrationException();
        }
    }

}
