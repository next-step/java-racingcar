package game.race.domain.support.move.impl;

import java.util.Random;

import game.race.domain.support.move.MovePolicy;

public class RandomPolicy implements MovePolicy {

    private static final int THRESHOLD = 4;

    @Override
    public boolean move() {
        int number = getPolicyNumber();
        return (number > THRESHOLD);

    }

    protected int getPolicyNumber() {
        return new Random().nextInt(10);
    }
}
