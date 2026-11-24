package racingcar;

import java.util.Objects;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVE_DISTANCE = 1;
    private int position;
    private final String name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        validateName(name);
        this.position = position;
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new RuntimeException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void tryMove(int number) {
        if (number < MOVE_THRESHOLD) {
            return;
        }
        position += MOVE_DISTANCE;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
