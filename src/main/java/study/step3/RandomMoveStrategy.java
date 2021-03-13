package study.step3;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{
    @Override
    public boolean isMove(int condition) {
        return new Random().nextInt(NumberChecker.RANDOM_BOUND) >= condition;
    }
}
