package step6.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVE_THRETHOLD = 4;
    private static final Random rd = new Random();

    @Override
    public boolean move() {
        return MOVE_THRETHOLD >= getRandomNumber();
    }

    private int getRandomNumber() {
        return rd.nextInt(MAX_RANDOM_NUMBER) + 1;
    }
}
