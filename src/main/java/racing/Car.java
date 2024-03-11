package racing;

import racing.strategy.MoveStrategy;

import java.util.Objects;

public class Car {

    private final Position position;
    private final Name name;

    public Car(String name) {
        this.position = new Position();
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String carPosition() {
        return position.dashOfPosition();
    }

    public void play(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position.addOne();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
