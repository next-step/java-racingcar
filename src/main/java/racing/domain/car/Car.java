package racing.domain.car;

import java.util.Objects;

public class Car {

    private static final int STANDARD_NUMBER_MOVE_FORWARD = 4;
    private static final int INITIATE_POSITION_VALUE = 0;

    private final Name name;
    private Position position;

    public Car(Car car) {
        this(car.getNameValue(), car.getPositionValue());
    }

    public Car(String name) {
        this(name, INITIATE_POSITION_VALUE);
    }

    public Car(String name, int position) {
        this(new Name(name), new Position(position));
    }

    public Car(Name name, Position position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public boolean isSamePosition(final Position position) {
        return this.position.equals(position);
    }

    public void drive(int condition) {
        if (condition >= STANDARD_NUMBER_MOVE_FORWARD) {
            position = position.move();
        }
    }

    public int getPositionValue() {
        return position.getValue();
    }

    public String getNameValue() {
        return name.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
