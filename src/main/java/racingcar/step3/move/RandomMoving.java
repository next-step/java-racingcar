package racingcar.step3.move;

import racingcar.step3.move.Moving;

import java.util.Random;

public class RandomMoving implements Moving {

    public static final int MAX_NUM = 9;
    public static final int MIN_NUM = 4;

    @Override
    public boolean isMovable() {
        return getRandomNum() >= MIN_NUM && getRandomNum() <= MAX_NUM;
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_NUM);
    }

}
