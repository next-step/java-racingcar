package step4.domain;

import step4.util.RandomGenerator;

public class RandomRacingStrategy implements RacingStrategy {
    public RandomRacingStrategy() {
    }

    @Override
    public void move(Car car) {
        if (shouldMove()) {
            car.move();
        }
        car.record();
    }

    private boolean shouldMove() {
        return ((int) (RandomGenerator.getRandomLessThan(10))) >= 4;
    }
}
