package racingcar.domain;

import java.util.Objects;

public class RacingCar {
    private static final int RANDOM_REFERENCE_VALUE = 4;
    private final Car car;
    private final MoveCounter moveCounter;

    public RacingCar(String carName) {
        this.car = new Car(carName);
        this.moveCounter = new MoveCounter();
    }

    public RacingCar(String carName, int moveCount) {
        this.car = new Car(carName);
        this.moveCounter = new MoveCounter(moveCount);
    }

    public int getMoveCount() {
        return moveCounter.getMoveCount();
    }

    public String getCarName() { return car.getName(); }

    public void goOrStopRacing(int randomValue) {
        if (randomValue >= RANDOM_REFERENCE_VALUE) {
            moveCounter.move();
        }
    }

    public boolean isMoveCountEqualMaxCount(int maxCount) {
        return moveCounter.isMoveCountEqualMaxCount(maxCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(car, racingCar.car) &&
                Objects.equals(moveCounter, racingCar.moveCounter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, moveCounter);
    }
}
