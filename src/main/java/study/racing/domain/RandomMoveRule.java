package study.racing.domain;

import java.util.Random;

public class RandomMoveRule {

    private static final int STANDARD_NUMBER = 9;
    private static final int MIN_NUMBER = 4;

    public static boolean isRandomNumber() {
        return new Random().nextInt(STANDARD_NUMBER) >= MIN_NUMBER;
    }
}
