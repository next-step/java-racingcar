package racinggame.domain.car;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.exception.InvalidCarNameException;
import racinggame.domain.exception.InvalidCarRegistrationException;

public class CarsInitializer {

    public static final String DELIMITER = ",";

    public static Cars initCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] carNameArray = splitCarNames(carNames);

        for (String carName : carNameArray) {
            validateCarNameLength(carName);
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }

    private static String[] splitCarNames(String carNames) {
        validateCarNamesNull(carNames == null);

        String[] carNameArray = carNames.split(DELIMITER);
        validateCarCount(carNameArray);

        return carNameArray;
    }

    private static void validateCarCount(String[] carNameArray) {
        if (carNameArray.length == 0) {
            throw new InvalidCarRegistrationException();
        }
    }

    private static void validateCarNamesNull(boolean carNames) {
        if (carNames) {
            throw new InvalidCarRegistrationException();
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > 5 || carName.length() == 0) {
            throw new InvalidCarNameException();
        }
    }

}
