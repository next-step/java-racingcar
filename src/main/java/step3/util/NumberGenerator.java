package step3.util;

import java.util.Random;

public class NumberGenerator {
    public static int makeRandomly() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
