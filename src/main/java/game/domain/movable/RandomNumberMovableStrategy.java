package game.domain.movable;

import utils.RandomNumberUtils;

public class RandomNumberMovableStrategy implements MovableStrategy {

    public static final int BOUND = 10;
    public static final int STANDARD_TO_MOVE = 4;

    @Override
    public boolean movable() {
        return RandomNumberUtils.getRandomNumber(BOUND) >= STANDARD_TO_MOVE;
    }
}
