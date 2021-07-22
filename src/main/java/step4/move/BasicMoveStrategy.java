package step4.move;

import java.util.Random;

public class BasicMoveStrategy implements MovableStrategy {
    private static final int CRITERION_NUMBER = 4;
    private static final int MAX_NUMBER = 9;
    private static final Random random = new Random();

    @Override
    public int move() {
        return makeNumber() >= CRITERION_NUMBER ? 1 : 0;
    }

    private int makeNumber() {
        return random.nextInt(MAX_NUMBER);
    }
}
