package study.racinggame.domain.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    final static Random RANDOM = new Random();
    final static int MINIMUM_MOVEMENT_NUMBER = 4;
    final static int RANDOM_BOUND = 10;

    @Override
    public boolean canMove() {
        return RANDOM.nextInt(RANDOM_BOUND) >= MINIMUM_MOVEMENT_NUMBER;
    }
}