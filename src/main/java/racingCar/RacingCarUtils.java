package racingCar;

import java.util.Random;

public class RacingCarUtils {
    private static final int BOUNDARY = 10;

    public static int randomValueGenerator() {
        return new Random().nextInt(BOUNDARY);
    }
}
