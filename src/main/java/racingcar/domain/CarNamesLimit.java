package racingcar.domain;

import java.util.function.Predicate;

public class CarNamesLimit {
    private static final int CAR_NAME_LIMIT = 5;

    public void checkLength(String[] carNames) {
        boolean result = false;

        for(String carName : carNames) {
            result = checkOverCarNameLimit(carName);
        }

        if(result) {
            System.exit(0);
        }
    }

    public boolean checkOverCarNameLimit(String carName) {
        Predicate<String> checkLength = (text) -> text.length() > CAR_NAME_LIMIT;

        return checkLength.test(carName);
    }
}
