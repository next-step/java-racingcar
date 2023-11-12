package game.race.support.move.impl;

import java.util.Random;

import game.race.support.move.MovePolicy;

public class RandomPolicy extends MovePolicy {

    private static final int THRESHOLD = 4;

    @Override
    public int move(int number) {
        return (number > THRESHOLD) ? number : 0;

    }

    @Override
    public int getMoveCount(int policyNumber) {
        return policyNumber;
    }

    public static int getPolicyNumber() {
        return new Random().nextInt(10);
    }
}
