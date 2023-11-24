package racing.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{

    public static final int MAX_RANDOM_NUMBER = 10;
    public static final int MOVE_CONDITION = 4;
    private final Random random = new Random();

    @Override
    public boolean movable() {
        int randomNumber = random.nextInt(MAX_RANDOM_NUMBER);
        return randomNumber >= MOVE_CONDITION;
    }
}
