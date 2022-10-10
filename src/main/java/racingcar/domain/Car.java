package racingcar.domain;

import racingcar.condition.MoveCondition;

import java.util.Objects;

public class Car {
    private final int MOVE_POSITION = 1;
    private final int NAME_MAX_LENGTH = 5;
    private final String ERROR_CHECK_LENGTH = "자동차 이름은 " + NAME_MAX_LENGTH + "자를 초과할 수 없다.";
    private MoveCondition moveCondition;
    private String name;
    private int position;

    public Car(String name, MoveCondition moveCondition) {
        this(name, 0, moveCondition);
    }

    public Car(String name, int position) {
        this(name, position, null);
    }

    public Car(String name, int position, MoveCondition moveCondition) {
        checkLength(name);
        this.name = name.trim();
        this.position = position;
        this.moveCondition = moveCondition;
    }

    private void checkLength(String name) {
        if (NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException(ERROR_CHECK_LENGTH);
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    boolean hasMaxPosition(int position) {
        return this.position == position;
    }

    int comparePosition(int position) {
        if (position < this.position) {
            position = this.position;
        }
        return position;
    }

    public void move(MoveCondition moveCondition) {
        if (moveCondition.isMovable()) {
            this.position += MOVE_POSITION;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return MOVE_POSITION == car.MOVE_POSITION && NAME_MAX_LENGTH == car.NAME_MAX_LENGTH && position == car.position && Objects.equals(ERROR_CHECK_LENGTH, car.ERROR_CHECK_LENGTH) && Objects.equals(moveCondition, car.moveCondition) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MOVE_POSITION, NAME_MAX_LENGTH, ERROR_CHECK_LENGTH, moveCondition, name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "moveCondition=" + moveCondition +
                ", position=" + position +
                ", name='" + name + '\'' +
                ", MOVE_POSITION=" + MOVE_POSITION +
                ", NAME_MAX_LENGTH=" + NAME_MAX_LENGTH +
                '}';
    }
}
