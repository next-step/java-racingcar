package racing.util;

import java.util.Random;

public class Dice {
    public static int cast() {
        return new Random().nextInt(10);
    }
}
