package racingcar.domain.movable;

import racingcar.domain.RandomNumberGenerator;

public class ForwardStrategy implements MovableStrategy {

    private static final int STANDARD_NUMBER_OF_MOVE_FORWARD = 4;

    @Override
    public boolean move() {
        return RandomNumberGenerator.generateRandomNumber() >= STANDARD_NUMBER_OF_MOVE_FORWARD;
    }
}
