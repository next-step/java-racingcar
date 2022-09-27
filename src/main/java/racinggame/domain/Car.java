package racinggame.domain;

import racinggame.util.RandomUtils;

import java.util.function.IntPredicate;

public class Car {

    private static final int CAN_MOVE_MIN_NUMBER = 4;

    private final IntPredicate canMovePredicate;

    private int distance;

    public Car() {
        canMovePredicate = randomNumber -> randomNumber >= CAN_MOVE_MIN_NUMBER;
    }

    public Car(IntPredicate canMovePredicate) {
        this.canMovePredicate = canMovePredicate;
    }

    public int distance() {
        return distance;
    }

    public void move() {
        move(RandomUtils.randomNumber(RandomUtils.MAX_RANDOM_NUMBER));
    }

    public void move(int randomNumber) {
        if (!canMovePredicate.test(randomNumber)) {
            return;
        }

        this.distance++;
    }
}
