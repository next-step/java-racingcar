package winner.domain;

import java.util.Random;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-01 21:27
 */
public class CarMoveStrategy implements MovableStrategy {

    private final static Random random = new Random();
    private final static int MAXIMUM_BOUND = 10;
    private final static int MINIMUM_CAR_MOVE = 4;

    @Override
    public boolean isMove() {
        return random.nextInt(MAXIMUM_BOUND) >= MINIMUM_CAR_MOVE;
    }
}
