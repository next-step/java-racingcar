package step3;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private final static int MOVE_CONDITION = 4;
    private static final Random random = new Random();

    @Override
    public boolean test() {
        return random.nextInt(10) > MOVE_CONDITION;
    }
}
