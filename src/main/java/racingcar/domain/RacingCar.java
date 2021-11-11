package racingcar.domain;

import java.util.Objects;

public class RacingCar {
    private static final int RANDOM_REFERENCE_VALUE = 4;
    private int moveCount;

    public RacingCar() {
        this.moveCount = 0;
    }

    public RacingCar(int moveCount) {
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void goOrStopRacing(int randomValue) {
        if (randomValue >= RANDOM_REFERENCE_VALUE)
            this.moveCount++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return moveCount == racingCar.moveCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveCount);
    }
}
