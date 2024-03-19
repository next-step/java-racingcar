package racingcar.domain;

import java.util.Random;

public class RandomNumberStrategy implements MoveStrategy {

    private static final int MAX_NUMBER = 10;

    private Random random = new Random();

    @Override
    public int getMoveNumber() {
        return random.nextInt(MAX_NUMBER);
    }
}
