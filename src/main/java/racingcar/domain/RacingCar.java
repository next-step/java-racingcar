package racingcar.domain;

import java.util.Objects;

public class RacingCar {
    private static final int RANDOM_REFERENCE_VALUE = 4;
    private String carName;
    private int moveCount;

    public RacingCar(String carName) {
        this.carName = carName;
        this.moveCount = 0;
    }

    public RacingCar(int moveCount) {
        this.moveCount = moveCount;
    }

    public RacingCar(String carName, int moveCount) {
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getCarName() { return carName; }

    public void goOrStopRacing(int randomValue) {
        if (randomValue >= RANDOM_REFERENCE_VALUE)
            this.moveCount++;
    }

    public boolean isMoveCountEqualMaxCount(int maxCount) {
        return this.moveCount == maxCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return moveCount == racingCar.moveCount &&
                Objects.equals(carName, racingCar.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, moveCount);
    }
}
