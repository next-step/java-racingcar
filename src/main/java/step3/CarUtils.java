package step3;

import java.util.Random;

public class CarUtils {

    private static final int NUMBER_RANGE = 10;

    public static int getNumberForMovement() {
        Random random = new Random();
        return random.nextInt(NUMBER_RANGE);
    }
}
