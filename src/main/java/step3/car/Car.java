package step3.car;

import step3.number.Number;
import step3.output.BarOutputView;
import step3.position.Position;

import java.util.Objects;

public final class Car {

    private static final int NUMBER_OF_JUDGMENT_THAT_CAN_GO_FORWARD = 4;

    private final Position position;

    private final Number number;

    public Car(Number number) {
        this(new Position(0, new BarOutputView()), number);
    }

    public Car(Position position, Number number) {
        this.position = position;
        this.number = number;
    }

    public Car movedCar() {
        if (number.generatedNumber() >= NUMBER_OF_JUDGMENT_THAT_CAN_GO_FORWARD) {
            return new Car(position.movedPosition(), number);
        }
        return this;
    }

    public void printPosition() {
        position.printPosition();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

}
