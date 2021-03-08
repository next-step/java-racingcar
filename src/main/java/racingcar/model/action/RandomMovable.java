package racingcar.model.action;

import java.util.Random;

public class RandomMovable implements Movable{

    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_VALUE = 10;
    private static final int CRETERION_VALUE = 4;

    @Override
    public int makeRandomValue() {
        return RANDOM.nextInt(MAX_RANDOM_VALUE);
    }

    @Override
    public boolean MoveOrNot(int randomValue) {
        return randomValue >= CRETERION_VALUE ? true : false;
    }
}
