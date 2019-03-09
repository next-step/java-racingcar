package racingcar.random;

import racingcar.Car;

public class CarMoveThresholdGenerator implements RandomIntGenerator {
    @Override
    public int getRandomInt() {
        return Car.MOVE_THRESHOLD;
    }
}
