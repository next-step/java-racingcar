package study.step3;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{
    @Override
    public boolean isMove() {
        return new Random().nextInt(NumberChecker.RANDOM_BOUND) >= NumberChecker.CONDITION_OF_START;
    }
}
