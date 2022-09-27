package step3.car;

import step3.number.Number;

import java.util.Objects;

public final class RacingCar implements Car {

    private static final int NUMBER_OF_JUDGMENT_THAT_CAN_GO_FORWARD = 4;

    private final int position;

    private final Number number;

    public RacingCar(Number number) {
        this(0, number);
    }

    public RacingCar(int position, Number number) {
        this.position = position;
        this.number = number;
    }

    @Override
    public Car movedCar() {
        if (number.generatedNumber() >= NUMBER_OF_JUDGMENT_THAT_CAN_GO_FORWARD) {
            return new RacingCar(1, number);
        }
        return new RacingCar(0, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return position == racingCar.position && Objects.equals(number, racingCar.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

}
