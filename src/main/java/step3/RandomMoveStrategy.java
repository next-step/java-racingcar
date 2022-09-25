package step3;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MIN_BOUND_NO = 4;
    private static final int MAX_BOUND_NO = 9;
    public static final int BOUND = 10;

    @Override
    public boolean movable() {
        return inBound( new Random().nextInt(BOUND));
    }

    private boolean inBound(int randomNo) {
        return randomNo >= MIN_BOUND_NO && randomNo <= MAX_BOUND_NO;
    }


}
