package step3.domain;

import step3.util.RandomGenerator;

public class RandomRacingStrategy implements RacingStrategy {
    public RandomRacingStrategy() {

    }

    @Override
    public void move(Car car) {
        if (shouldMove()) {
            car.move();
        }
    }

    private static boolean shouldMove() {
        return ((int) (RandomGenerator.getRandomLessThan(10))) >= 4;
    }
}
