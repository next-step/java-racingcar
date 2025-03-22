package racingcar.domain;

import racingcar.strategy.MovingStrategy;

public class Car {
    public static final int CAR_NAME_SIZE = 5;

    private String name;
    private int moveCount;

    public Car() {
        this.moveCount = 1;
    }

    public Car(String name) {
        validName(name);
        this.name = name;
        this.moveCount = 1;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            moveCount++;
        }
    }

    private void validName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈값일 수 없습니다.");
        }
        if (name.length() > CAR_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
