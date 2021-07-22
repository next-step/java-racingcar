package racingCar.util;

import java.util.Random;

public class RandomNumber {
    private static final int BOUND_BY_RACING_CAR = 10;

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(BOUND_BY_RACING_CAR);
    }

}
