package domain.car;

import java.util.Random;

public class Dice {
    private static final Random RANDOM = new Random();

    public static int roll() {
        return RANDOM.nextInt(10);
    }
}
