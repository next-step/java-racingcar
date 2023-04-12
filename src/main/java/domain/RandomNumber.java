package domain;

import java.util.Random;

public class RandomNumber {

    public static final Random RANDOM = new Random();
    public static final int OUT_OF_TEN = 10;
    public static final int MINIMUM_MOVABLE_VALUE = 4;

    public static int generateRandomOutOfTen() {
        return RANDOM.nextInt(OUT_OF_TEN);
    }

    public static boolean isOverFourOutOfTen() {
        return generateRandomOutOfTen() >= MINIMUM_MOVABLE_VALUE;
    }
}
