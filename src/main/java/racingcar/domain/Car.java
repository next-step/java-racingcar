package racingcar.domain;

import racingcar.domain.movable.MovableStrategy;

public class Car {

    private static final int MIN_LIMITED_CAR_NAME_LENGTH = 0;
    private static final int MAX_LIMITED_CAR_NAME_LENGTH = 5;
    private static final int MOVE_DISTANCE_AT_ONCE = 1;

    private final String name;
    private final int distance;

    public Car(final String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    private Car(final String name, final int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car of(final String name, final int distance) {
        return new Car(name, distance);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public Car run(MovableStrategy strategy) {
        if (strategy.isMovable()) {
            return of(name, distance + MOVE_DISTANCE_AT_ONCE);
        }

        return of(name, distance);
    }

    public boolean isEqualDistance(final int distance) {
        return this.distance == distance;
    }

    private void validateName(final String name) {
        int nameLength = name.length();

        if (nameLength == MIN_LIMITED_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 공백이 될 수 없습니다.");
        }

        if (nameLength > MAX_LIMITED_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(
                "이름은 " + MAX_LIMITED_CAR_NAME_LENGTH + "자를 넘을 수 없습니다.");
        }
    }

}
