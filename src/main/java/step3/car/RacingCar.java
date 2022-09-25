package step3.car;

import step3.number.Number;

import java.util.Objects;

public final class RacingCar implements Car {

    private static final int NUMBER_OF_JUDGMENT_THAT_CAN_GO_FORWARD = 4;

    private int position;

    private Number number;

    public RacingCar(Number number) {
        this(0, number);
    }

    public RacingCar(int position, Number number) {
        this.position = position;
        this.number = number;
    }

    @Override
    public void useTurn() {
        if (number.generatedNumber() >= NUMBER_OF_JUDGMENT_THAT_CAN_GO_FORWARD) {
            position += 1;
        }
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
