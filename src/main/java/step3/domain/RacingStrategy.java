package step3.domain;

import step3.util.RandomGenerator;

public class RacingStrategy {
    private RacingStrategy() {

    }

    public static void move(Car car) {
        if (shouldMove()) {
            car.move();
        }
    }

    private static boolean shouldMove() {
        return ((int) (RandomGenerator.getRandomBetweenZeroToOne() * 10)) >= 4;
    }
}
