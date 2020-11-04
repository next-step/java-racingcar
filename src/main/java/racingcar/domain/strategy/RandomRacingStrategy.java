package racingcar.domain.strategy;

import racingcar.domain.car.Car;
import racingcar.util.RandomGenerator;

public class RandomRacingStrategy implements RacingStrategy {
    public RandomRacingStrategy() {
    }

    @Override
    public void move(Car car) {
        if (shouldMove()) {
            car.move();
        }
    }

    private boolean shouldMove() {
        return ((int) (RandomGenerator.getRandomLessThan(10))) >= 4;
    }
}
