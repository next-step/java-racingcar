package step5.util;

import java.util.Random;

public class NumberGenerator {

    private static final Integer LESS_THAN_TEN = 10;

    public static int createRandomNumbers() {
        return new Random().nextInt(LESS_THAN_TEN);
    }

}
