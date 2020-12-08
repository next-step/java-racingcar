package racingCar;

import java.util.Random;

public class RacingCarUtils {
    private static final int BOUNDARY = 10;

    public static int randomValueGenerator() {
        return new Random().nextInt(BOUNDARY);
    }

    public static void checkCarNameRule(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("can not exceed 5 characters : " + carName);
        }
    }

    public static String[] splitCarNames(String carNames) {
        String[] cars = carNames.split(",");
        return cars;
    }
}
