package racing.domain;

import racing.exception.CarNameLengthException;

public class CarValidator {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void checkCarNamesLength(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new CarNameLengthException(name);
        }
    }
}
