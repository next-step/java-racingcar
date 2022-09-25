package racinggame.core;

import java.util.ArrayList;
import java.util.List;
import racinggame.exception.InvalidCarRegistrationException;

public class GameInitializer {

    public static final String DELIMITER = ",";

    public static List<Car> initCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] carNameArray = carNames.split(DELIMITER);
        validCarNames(carNameArray);

        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private static void validCarNames(String[] carNameArray) {
        if (carNameArray.length <= 0) {
            throw new InvalidCarRegistrationException();
        }
    }

}
