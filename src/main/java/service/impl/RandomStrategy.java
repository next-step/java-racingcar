package service.impl;

import service.GameStrategy;

import java.util.Random;

public class RandomStrategy implements GameStrategy {

    public final int MAX_BOUND_NUMBER = 10;
    public static final int MIN_MOVE_NUMBER = 4;
    private final Random random = new Random();

    @Override
    public boolean isCarMove() {
        return this.isCarMove(getRandomNum());
    }

    private int getRandomNum() {
        return this.random.nextInt(MAX_BOUND_NUMBER);
    }

    boolean isCarMove(int randNumber) {
        return randNumber >= MIN_MOVE_NUMBER;
    }
}