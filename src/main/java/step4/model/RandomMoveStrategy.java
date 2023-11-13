package step4.model;

import java.util.Random;

import static step4.constants.RandomMoveConstants.MAX_RANDOM_VALUE;
import static step4.constants.RandomMoveConstants.MOVE_CONDITION;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMovable() {
        int randomValue = new Random().nextInt(MAX_RANDOM_VALUE);
        return (randomValue >= MOVE_CONDITION);
    }
}
