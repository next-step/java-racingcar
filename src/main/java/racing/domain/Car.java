package racing.domain;

import racing.domain.strategy.MovingStrategy;

import java.util.Objects;

public class Car {
    private final CarName name;
    private final Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, String position) {
        this(name, Integer.parseInt(position));
    }

    public Car(String name, int position) {
        this(new CarName(name), new Position(position));
    }

    public Car(CarName name, int position) {
        this(name, new Position(position));
    }

    public Car(String name, Position position) {
        this(new CarName(name), position);
    }

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position.move();
        }
    }

    public String getName() {
        return name.toString();
    }

    public boolean isWinnerPosition(int position) {
        return this.position.isMaxPosition(position);
    }

    public int getPosition() {
        return position.getPosition();
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
        return name + ": " + position;
    }


}
