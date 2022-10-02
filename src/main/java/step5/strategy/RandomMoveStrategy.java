package step5.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MIN_BOUND_NUMBER = 4;
    private static final int MAX_BOUND_NUMBER = 9;
    public static final int BOUND = 10;

    @Override
    public boolean movable() {
        return inBound( new Random().nextInt(BOUND) );
    }

    private boolean inBound(int randomNumber) {
        return randomNumber >= MIN_BOUND_NUMBER && randomNumber <= MAX_BOUND_NUMBER;
    }


}
