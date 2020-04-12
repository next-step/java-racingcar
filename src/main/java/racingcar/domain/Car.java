package racingcar.domain;

import java.util.Objects;

public class Car {

    private Position position;
    private final String name;
    private final MovableStrategy movableStrategy;

    public Car(MovableStrategy movableStrategy, String name) {
        validateName(name);
        this.movableStrategy = movableStrategy;
        this.name = name.trim();
        this.position = new Position();
    }

    public Car(MovableStrategy movableStrategy, String name, int position) {
        validateName(name);
        this.movableStrategy = movableStrategy;
        this.name = name.trim();
        this.position = new Position(position);
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || "".equals(name.trim())) {
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
        return position.equals(car.position) &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
