package step3and4.car;

import step3and4.number.Number;
import step3and4.output.OutputView;

import java.util.Objects;

public final class Car {

    private static final int NUMBER_OF_JUDGMENT_THAT_CAN_GO_FORWARD = 4;

    private final Position position;

    private final Number number;

    public Car(Number number, OutputView outputView) {
        this(new Position(0, outputView), number);
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
