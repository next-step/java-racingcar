package racingcar;

import java.util.Random;

public class RandomBool {
    private static final Random RANDOM = new Random;

    public static boolean next() {
        return toBool(RANDOM.nextInt(10));
    }

    public static boolean toBool(int number) {
        if (number >= 0 && number < 4) {
            return false;
        }
        if (number >= 4 && number <= 9) {
            return true;
        }

        throw new RuntimeException();
    }
}
