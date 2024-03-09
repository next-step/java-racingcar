package model;

import static util.RandomUtil.randomNumber;

public class RandomMove implements MoveStrategy {
    private static final int BOUNDARY_VALUE = 4;

    @Override
    public boolean movable() {
        return randomNumber() >= BOUNDARY_VALUE;
    }
}
