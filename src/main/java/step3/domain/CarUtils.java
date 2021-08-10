package step3.domain;

import java.util.Random;

public class CarUtils {

    private static final int NUMBER_RANGE = 10;
    private static final int CAR_NAME_MAXIMUM_LENGTH = 5;

    public static int getNumberForMovement() {
        Random random = new Random();
        return random.nextInt(NUMBER_RANGE);
    }

    public static boolean validateNameLength(String carName) {
        return carName.length() <= CAR_NAME_MAXIMUM_LENGTH;
    }
}
