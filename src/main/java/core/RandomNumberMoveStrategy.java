package core;

import java.util.Random;

public class RandomNumberMoveStrategy implements MoveStrategy {
    private static final int RANDOM_NUMBER = 10;
    private static final int GOING_NUM = 4;

    Random random = new Random();

    @Override
    public boolean isMove() {
        return random.nextInt(RANDOM_NUMBER) >= GOING_NUM;
    }
}
