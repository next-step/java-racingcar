package step3and4.game.car;

import step3and4.client.number.Number;

import java.util.Objects;

public final class Car {

    private static final int NUMBER_OF_JUDGMENT_THAT_CAN_GO_FORWARD = 4;

    private final Position position;

    private final Number number;

    private final Name name;

    public Car(Number number, Name name) {
        this(new Position(0), number, name);
    }

    public Car(Number number) {
        this(new Position(0), number, new Name(""));
    }

    public Car(Position position, Number number) {
        this(position, number, new Name(""));
    }

    public Car(Position position, Number number, Name name) {
        this.position = position;
        this.number = number;
        this.name = name;
    }

    public Car movedCar() {
        if (number.generatedNumber() >= NUMBER_OF_JUDGMENT_THAT_CAN_GO_FORWARD) {
            return new Car(position.movedPosition(), number);
        }
        return this;
    }

    @Override
    public String toString() {
        return name.toString() + position.toString();
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
