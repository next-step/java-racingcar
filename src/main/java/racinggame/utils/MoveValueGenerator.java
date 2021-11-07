package racinggame.utils;

import java.util.Random;

public class MoveValueGenerator {

    private static final Random random = new Random();

    public static int generateMoveValue() {
        return random.nextInt(10);
    }
}
