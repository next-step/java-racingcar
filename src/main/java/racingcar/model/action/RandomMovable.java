package racingcar.model.action;

import java.util.Random;

public class RandomMovable implements Movable{

    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_VALUE = 10;
    private static final int CRETERION_VALUE = 4;
    private int randomValue;

    public int makeRandomValue() {
        randomValue = RANDOM.nextInt(MAX_RANDOM_VALUE);
        return randomValue;
    }

    @Override
    public boolean moveOrNot() {
        return getRandomValue() >= CRETERION_VALUE;
    }

    public int getRandomValue() {
        return randomValue;
    }

}
