package racingcar.domain;


import java.util.Objects;

public class RacingCar {
    private final int NUMBER_MOVING_STANDARD = 4;
    private final String carName;
    private int position = 0;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public RacingCar(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public int move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            return ++position;
        }
        return position;
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= NUMBER_MOVING_STANDARD;
    }

    public boolean isInPosition(int farthestPosition) {
        return position == farthestPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return position == racingCar.position &&
                carName.equals(racingCar.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "carName='" + carName + '\'' +
                ", position=" + position +
                '}';
    }
}
