package racingCar;

import java.util.Random;

public class RacingCarUtils {
    private static final int BOUNDARY = 10;

    public static int randomValueGenerator() {
        return new Random().nextInt(BOUNDARY);
    }

    public static void checkCarNameRule(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("can not exceed 5 characters : " + car);
        }
    }
}
