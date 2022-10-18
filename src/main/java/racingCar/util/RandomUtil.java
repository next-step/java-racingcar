package racingCar.util;

import java.util.Random;

public class RandomUtil {

    private static final int RACING_CAR_NUM_RANGE = 10;
    private static final int RACING_CAR_MOVEABLE_MINIMUM = 4;

    private static Random random = new Random();

    public static int randomNumberInRange(int boundaryValue) {
        return random.nextInt(boundaryValue);
    }

    public static boolean isRandomNumberUnderBVGreaterThanOrEqualCV(int boundaryValue, int comparisonValue) {
        return randomNumberInRange(boundaryValue) >= comparisonValue;
    }

    public static boolean isRandomNumberUnder10GreaterThanOrEqual4() {
        return isRandomNumberUnderBVGreaterThanOrEqualCV(RACING_CAR_NUM_RANGE, RACING_CAR_MOVEABLE_MINIMUM);
    }
}
