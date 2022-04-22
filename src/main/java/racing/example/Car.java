package racing.example;

import java.util.Objects;

public class Car {
    private static final int FORWARD_NUM = 4;

    private final String name;
    private Position position;

    public Car(String name) {
        this(name, new Position());
    }

    public Car(String name, int position) {
        this(name, new Position(position));
    }

    public Car(String name, Position position) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.name = name.trim();
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public Position move(int randomNo) {
        if (randomNo >= FORWARD_NUM) {
            this.position = new Position(this.position);
        }

        return this.position;
    }

    public boolean isWinner(int maxPosition) {
        return this.position.isMaxPosition(maxPosition);
    }

    public int maxPosition(int maxPosition) {
        return this.position.maxPosition(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
