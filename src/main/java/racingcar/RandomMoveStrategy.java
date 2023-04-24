package racingcar;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final Integer MINIMUM_NUMBER_TO_MOVE = 4;
    private static final Integer MAX_NUMBER = 10;
    private static final Random RANDOM = new Random();

    @Override
    public boolean isMovable() {
        return randomNumber() >= MINIMUM_NUMBER_TO_MOVE;
    }

    private Integer randomNumber() {
        return RANDOM.nextInt(MAX_NUMBER);
    }
}
