package step4.model;

import java.util.Random;

import static step4.constants.RandomMoveConstants.MAX_RANDOM_VALUE;
import static step4.constants.RandomMoveConstants.MOVE_CONDITION;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMovable() {
        return (new Random().nextInt(MAX_RANDOM_VALUE) >= MOVE_CONDITION);
    }
}
