package stage4.domain;

import java.util.Objects;

public class Car {
    private final static int THRESHOLD = 4;

    private final CarName name;
    private final Position position;


    public Car(CarName name) {
        this.name = name;
        this.position = new Position();
    }

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(Car car) {
        this.name = new CarName(car.name);
        this.position = new Position(car.position);
    }


    public Position getPosition() {
        return this.position;
    }

    public CarName getName() {
        return this.name;
    }


    public Position tryForward(MovableStrategy randomMovableStrategy) {
        if (this.isForward(randomMovableStrategy.getForwardPosition())) {
            this.move();
        }
        return this.position;
    }

    private void move() {
        this.position.forward();
    }

    private boolean isForward(int condition) {
        return condition >= THRESHOLD;
    }

    public boolean isPosition(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    public Position findMaxPosition(Position max) {
        if (isGreaterThan(max)) {
            max = this.position;
        }
        return max;
    }

    private boolean isGreaterThan(Position max) {
        return this.position.greaterThan(max);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName()) && Objects.equals(getPosition(), car.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
