package racingcar.domain;

import racingcar.domain.movable.MovableStrategy;

public class Car {

    private static final int ZERO_CAR_NAME_LENGTH = 0;
    private static final int LIMITED_CAR_NAME_LENGTH = 5;

    private final String name;
    private int distance;

    public Car(final String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    public String name() {
        return name;
    }

    public int distance() { return distance; }

    public boolean isDistance(final int distance) { return this.distance == distance; }

    public void run(final MovableStrategy strategy) {
        if (strategy.isMovable()) {
            this.distance++;
        }
    }

    private void validateName(final String name) {
        if (name.length() == ZERO_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("최소한 플레이어 이름은 비어있을 수 없습니다.");
        }

        if (name.length() > LIMITED_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + LIMITED_CAR_NAME_LENGTH + "자를 넘을 수 없습니다.");
        }
    }
}
