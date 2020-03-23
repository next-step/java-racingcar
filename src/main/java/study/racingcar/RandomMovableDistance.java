package study.racingcar;

import java.util.Random;

public class RandomMovableDistance implements MovableDistance {
    private static final int BOUND = 10;
    private static final int BASE_POINT = 4;

    @Override
    public int getDistance() {
        int random = (new Random()).nextInt(BOUND);
        return (random >= BASE_POINT) ? 1 : 0;
    }
}
