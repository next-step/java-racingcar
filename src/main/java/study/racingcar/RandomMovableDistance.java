package study.racingcar;

import java.util.Random;

public class RandomMovableDistance implements MovableDistance {

    @Override
    public int getDistance() {
        int random = (new Random()).nextInt(10);
        return (random >= 4) ? 1 : 0;
    }
}
