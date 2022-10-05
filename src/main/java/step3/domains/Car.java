package step3.domains;

import java.util.Objects;

public class Car {
    private static final int START_POSITION = 0;

    private final CarName name;
    private final Position position;

    public static Car init(String name) {
        return new Car(name, START_POSITION);
    }

    public Car(String name, int position) {
        this(new CarName(name), new Position(position));
    }

    private Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return new Car(name, position.incrementAndGet());
        }

        return this;
    }

    public boolean isWinner(Car other) {
        return position.isGreaterOrEquals(other.position);
    }

    public Position getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.position);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Car car = (Car) obj;
        return Objects.equals(this.name, car.name) &&
                Objects.equals(this.position, car.position);
    }
}
