package racinggame.domain;

import calculator.StringUtils;
import racinggame.util.RandomUtils;

import java.util.function.IntPredicate;

public class Car {

    private static final int CAN_MOVE_MIN_NUMBER = 4;

    private IntPredicate canMovePredicate;

    private int distance;
    private String name;

    public Car(String name) {
        this(name, randomNumber -> randomNumber >= CAN_MOVE_MIN_NUMBER);
    }

    public Car(String name, IntPredicate canMovePredicate) {
        validateName(name);
        if (canMovePredicate == null) {
            throw new IllegalArgumentException("이동 전략을 필수값 입니다.");
        }

        this.canMovePredicate = canMovePredicate;
        this.name = name;
    }

    private void validateName(String name) {
        if (isInValidName(name)) {
            throw new IllegalArgumentException("이름은  4글자 이하여야 합니다.");
        }
    }

    public int distance() {
        return distance;
    }

    public String name() {
        return this.name;
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

    private boolean isInValidName(String name) {
        return (StringUtils.isEmpty(name) || name.length() >= 5);
    }
}
