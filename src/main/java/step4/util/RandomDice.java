package step4.util;


import java.util.Random;

public class RandomDice {

    private static final int RANDOM_MAXIMUM_BOUND = 10;

    private RandomDice() {
    }

    public static int rollTheDice() {
        return new Random().nextInt(RANDOM_MAXIMUM_BOUND);
    }

}
