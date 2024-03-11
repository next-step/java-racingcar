package racingcar.model;

import java.util.Random;

public class RandomNumberStrategy implements MoveStrategy {

    private static final int MAX_NUMBER = 10;

    @Override
    public int getMoveNumber() {
        Random random = new Random();
        return new Random().nextInt(MAX_NUMBER);
    }
}
