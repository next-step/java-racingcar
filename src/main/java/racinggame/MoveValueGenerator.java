package racinggame;

import java.util.Random;

public class MoveValueGenerator {

    public static final Random random = new Random();

    public static int generateMoveValue() {
        return random.nextInt(10);
    }
}
