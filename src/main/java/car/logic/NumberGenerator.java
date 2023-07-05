package car.logic;

import java.util.Random;

public class NumberGenerator {

    private static final int NUMBER_LIMIT = 10;

    public static int getRandomNumber() {
        Random ran = new Random();
        return ran.nextInt(NUMBER_LIMIT);
    }

}
