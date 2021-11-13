package racingcar.domain.moverule;

import utils.IntUtils;

public class RandomMoveRule implements MoveRule {

    private static final int MOVE_COUNT = 1;
    private static final int MOVE_STANDARD_VALUE = 4;
    private static final int RANDOM_BOUND_VALUE = 10;

    public boolean isMovable(){
        return IntUtils.getRandomUnder(RANDOM_BOUND_VALUE) >= MOVE_STANDARD_VALUE;
    }

    public int getMoveCount(){
        return MOVE_COUNT;
    }
}