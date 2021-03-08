package racingcar.model.action;

import java.util.Random;

public class RandomMovable implements Movable{

    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_VALUE = 10;

    @Override
    public int makeRandomValue() {
        return RANDOM.nextInt(MAX_RANDOM_VALUE);
    }

    @Override
    public boolean MoveOrNot(int randomValue) {
        return randomValue >= 4 ? true : false;
    }
}
