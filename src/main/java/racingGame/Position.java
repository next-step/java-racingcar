package racingGame;

import java.util.Random;

public class Position {
    private final int threshold = 4;
    private final Random random = new Random();

    public boolean canMove() {
        return random.nextInt(10) >= threshold;
    }
}
