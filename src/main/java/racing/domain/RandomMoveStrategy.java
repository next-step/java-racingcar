package racing.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{

    public static final int MAX_RANDOM_NUMBER = 10;
    public static final int MOVE_CONDITION = 4;

    @Override
    public boolean movable() {
        int randomNumber = new Random().nextInt(MAX_RANDOM_NUMBER);
        return randomNumber >= MOVE_CONDITION;
    }
}
