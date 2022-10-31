package step3.domain;

import step3.common.RandomBounded;

public class RacingCar {

    private static final int INITIAL_NUMBER = 0;

    private static final int INITIAL_POSITION = 0;

    private int number;

    private int position;

    public RacingCar() {
        this(INITIAL_NUMBER);
    }

    public RacingCar(int number) {
        this(number, INITIAL_POSITION);
    }

    public RacingCar(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public boolean goingAheadOrNot(RandomBounded randomBounded) {
        return randomBounded.moreThanForwardStandard();
    }

    public RacingCar goAhead() {
        int newPosition = this.position + 1;
        return new RacingCar(this.number, newPosition);
    }

    public int number() { return this.number; }

    public int position() {
        return this.position;
    }

    public RacingCar raceCar() {
        RacingCar racingCar = this;
        if (goingAheadOrNot(new RandomBounded())) {
            racingCar = this.goAhead();
        }
        return racingCar;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RacingCar && this.number() == ((RacingCar) o).number()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return number() * 13;
    }
}
