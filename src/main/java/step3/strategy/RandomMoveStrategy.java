package step3.strategy;

import step3.validite.RandomNumber;

public class RandomMoveStrategy implements MoveStrategy {

    private static final RandomNumber RANDOM_NUMBER = new RandomNumber();

    @Override
    public int move() {
        return RANDOM_NUMBER.randomNumberCreate();
    }
}
