package newRacingCar.domain;

import newRacingCar.utils.RandomUitls;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int COMPARE_VALUE = 4;

    public boolean move() {
        return RandomUitls.random() >= COMPARE_VALUE;
    }
}
