package racingcar.utility;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.utility.VerificationUtility.validateAttempt;
import static racingcar.utility.VerificationUtility.validateDuplication;

public class InitializeUtility {
    private static final String SEPARATOR = ",";

    private InitializeUtility() {
    }

    public static List<Car> initCar(String carNames) throws IllegalArgumentException {
        List<Car> carList = new ArrayList<>();
        String[] names = carNames.split(SEPARATOR);

        validateDuplication(names);

        for (String name : names) {
            carList.add(new Car(name));
        }

        return carList;
    }

    public static int initTotalAttempt(String attempt) throws IllegalArgumentException {
        return validateAttempt(attempt);
    }
}
