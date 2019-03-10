package racingcar.random;

import racingcar.Car;

public class IntMoreThanCarMoveThresholdGenerator implements RandomIntGenerator {
    @Override
    public int getRandomInt() {
        return Car.MOVE_THRESHOLD + 1;
    }
}
