package model;

import util.RandomUtil;


public class RandomMove implements MoveStrategy {
    private static final int BOUNDARY_VALUE = 4;

    private final RandomUtil randomUtil;

    public RandomMove() {
        this.randomUtil = new RandomUtil();
    }

    @Override
    public boolean movable() {
        return randomUtil.randomNumber() >= BOUNDARY_VALUE;
    }
}
