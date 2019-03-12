package racingcar.random;

import racingcar.domain.Car;

public class CarMoveThresholdGenerator implements RandomIntGenerator {
    @Override
    public int getRandomInt() {
        return Car.MOVE_THRESHOLD;
    }
}
