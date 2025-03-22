package step3.game;

import java.util.Objects;

public class Car {
    private String name;
    private int position = 0;

    private static final int POSSIBLE_MOVE_CONDITION = 4;
    private static final int MAX_MOVE_CONDITION = 9;
    private static final int MIN_MOVE_CONDITION = 0;

    public Car(String name) {
        this(name, 0);
    }
    public Car(String name, int position) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있거나 null이 될 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        this.name = name;
        this.position = position;
    }
    public void move(int number) {
        if (number > MAX_MOVE_CONDITION || number < MIN_MOVE_CONDITION) {
            throw new IllegalArgumentException("움직일 수 있는 조건을 벗어났습니다. 값 : " + number);
        }
        if (number >= POSSIBLE_MOVE_CONDITION) {
            position++;
        }
    }
    public boolean isSamePosition(int other) {
        return position == other;
    }

    public int max(int other) {
        return Math.max(position, other);
    }
    public Car copy() {
        return new Car(name, position);
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
