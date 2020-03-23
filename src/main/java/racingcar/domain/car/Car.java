package racingcar.domain.car;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private String name;
    private int position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    private Car(String name, int position) {
        validate(name);

        this.name = name;
        this.position = position;
    }

    private void validate(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 잘못 되었습니다.");
        }
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    public Car clone() {
        return new Car(name, position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner(int maxPosition) {
        return maxPosition == position;
    }
}
