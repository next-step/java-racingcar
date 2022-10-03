package racinggame.domain;

import racinggame.util.RandomUtils;

import java.util.function.IntPredicate;

public class Car {

    private static final int CAN_MOVE_MIN_NUMBER = 4;

    private IntPredicate canMovePredicate;

    private int distance;
    private CarName carName;

    public Car(String name) {
        this(name, randomNumber -> randomNumber >= CAN_MOVE_MIN_NUMBER);
    }

    public Car(String name, IntPredicate canMovePredicate) {
        if (canMovePredicate == null) {
            throw new IllegalArgumentException("이동 전략을 필수값 입니다.");
        }

        this.canMovePredicate = canMovePredicate;
        this.carName = new CarName(name);
    }

    public int distance() {
        return distance;
    }

    public CarName getCarName() {
        return this.carName;
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
