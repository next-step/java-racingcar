package racingcar.domain;

import java.util.Objects;

public class RacingCar implements Comparable<RacingCar> {

    private static final String racingCarNamePattern = "^[a-zA-Z0-9]{1,6}$";
    private String carName;
    private int carPosition;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public RacingCar(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public RacingCar run(MoveRule racingRule) {
        if(racingRule.isAbleToMove()) {
            carPosition++;
        }
        return new RacingCar(this.carName, this.carPosition);
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public static boolean validateCarName(String racingCarName) {
        return racingCarName.matches(racingCarNamePattern);
    }

    public boolean isSamePosition(RacingCar other) {
        return other.getCarPosition() == this.carPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return carPosition == racingCar.carPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carPosition);
    }

    @Override
    public int compareTo(RacingCar other) {
        return this.carPosition - other.getCarPosition();
    }
}
