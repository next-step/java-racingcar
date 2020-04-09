package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class Car {

    private Position position;
    private String name;
    private MovableStrategy movableStrategy;

    public Car(MovableStrategy movableStrategy, String name) {
        validateName(name);
        this.movableStrategy = movableStrategy;
        this.name = name.trim();
        this.position = new Position();
    }

    private void validateName(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException("자동차 이름이 비어있습니다");
        }
    }

    public void moveIfPossible() {
        if (movableStrategy.isMovable()) {
            position = position.increase();
        }
    }

    public int getMaxPosition(int maxPosition) {
        if (maxPosition < position.getPosition()) {
            return position.getPosition();
        }
        return maxPosition;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name;
    }

    public boolean isWinner(int maxPosition) {
        return maxPosition == position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) &&
                Objects.equals(name, car.name) &&
                Objects.equals(movableStrategy, car.movableStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name, movableStrategy);
    }
}
