package racing.util;

import java.util.Random;

public class NumberUtil {

    public static final Random RANDOM = new Random();

    public static int generateRandomNumberFromZeroToInputNumber(int number) {
        return RANDOM.nextInt(number);
    }

}
