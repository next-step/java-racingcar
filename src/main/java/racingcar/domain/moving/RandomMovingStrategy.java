package racingcar.domain.moving;

import static racingcar.domain.moving.Moving.*;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MIN_MOVING_VALUE = 4;
    private static final int MAX_MOVING_VALUE = 10;
    private static final Random RANDOM = new Random();
    
    @Override
    public Moving go() {
        if (randomValue() >= MIN_MOVING_VALUE) {
            return GO;
        }
        return STOP;
    }
    
    int randomValue() {
        return RANDOM.nextInt(MAX_MOVING_VALUE);
    }
}
