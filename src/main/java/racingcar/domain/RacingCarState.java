package racingcar.domain;

import java.util.Objects;

public class RacingCarState {
    private final String carName;
    private final int carNo;
    private final int position;

    private RacingCarState(String carName, int carNo, int position) {
        this.carName = carName;
        this.carNo = carNo;
        this.position = position;
    }

    public static RacingCarState valueOf(RacingCar racingCar) {
        return new RacingCarState(racingCar.getName(), racingCar.getCarNo(), racingCar.getPosition());
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCarNo() {
        return this.carNo;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarState that = (RacingCarState) o;
        return getCarNo() == that.getCarNo() && getPosition() == that.getPosition() && Objects.equals(getCarName(), that.getCarName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarName(), getCarNo(), getPosition());
    }
}
