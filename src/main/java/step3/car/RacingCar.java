package step3.car;

import step3.number.Number;
import step3.output.BarOutputView;
import step3.position.CarPosition;
import step3.position.Position;

import java.util.Objects;

public final class RacingCar implements Car {

    private static final int NUMBER_OF_JUDGMENT_THAT_CAN_GO_FORWARD = 4;

    private final Position position;

    private final Number number;

    public RacingCar(Number number) {
        this(new CarPosition(0, new BarOutputView()), number);
    }

    public RacingCar(Position position, Number number) {
        this.position = position;
        this.number = number;
    }

    @Override
    public Car movedCar() {
        if (number.generatedNumber() >= NUMBER_OF_JUDGMENT_THAT_CAN_GO_FORWARD) {
            return new RacingCar(position.movedPosition(), number);
        }
        return this;
    }

    @Override
    public void printPosition() {
        position.printPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(position, racingCar.position) && Objects.equals(number, racingCar.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

}
