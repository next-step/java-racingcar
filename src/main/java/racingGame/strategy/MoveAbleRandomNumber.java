package racingGame.strategy;

import java.util.Random;

public class MoveAbleRandomNumber implements MoveStrategy {

    private static final int RANDOM_NUMBER = 10;
    private static final int MOVE_ABLE_COUNT = 4;

    @Override
    public boolean moveAble() {
        if(getRandom() > MOVE_ABLE_COUNT){
            return true;
        }
        return false;
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER);
    }
}