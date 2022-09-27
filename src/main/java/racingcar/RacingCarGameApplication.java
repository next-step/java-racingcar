package racingcar.domain;

import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomValueStrategy;

public class RacingCarGame {
    public static void main(String[] args) {
        Car car = new Car();
        car.move(randomValue());
    }

    public static MovingStrategy randomValue() {
        return new RandomValueStrategy();
    }
}
