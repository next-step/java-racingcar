package racingcar.domain.strategy;

import racingcar.domain.Car;

import java.util.Random;

public interface MoveStrategy {

    Random random = new Random();
    int RANDOM_UPPER_BOUND = 10;

    boolean canMove(int number);

    default void moveOrStop(Car car) {
        int number = random.nextInt(RANDOM_UPPER_BOUND);
        if (canMove(number)) {
            car.move();
        }
    }
}
