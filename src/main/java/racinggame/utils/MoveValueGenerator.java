package racinggame.utils;

import java.util.Random;

public class MoveValueGenerator {

    private static final Random random = new Random();
    private static final int MAX = 10;

    private MoveValueGenerator() {
    }

    public static int generateMoveValue() {
        return random.nextInt(MAX);
    }
}
