package racingcar.domain;

import java.util.Objects;

import static racingcar.view.InputValidator.INVALID_NAME_ERROR_MESSAGE;

public class RacingCar implements Comparable<RacingCar> {

    private static final String racingCarNamePattern = "^[a-zA-Z0-9]{1,5}$";
    private String carName;
    private int carPosition;

    /*public RacingCar(String carName) {
        checkCarName(carName);
        this.carName = carName;
    }

    public RacingCar(String carName, int carPosition) {
        checkCarName(carName);
        this.carName = carName;
        this.carPosition = carPosition;
    }*/

    private void checkCarName(String racingCarName) {
        boolean isCorrectCarName = racingCarName.matches(racingCarNamePattern);

        if(!isCorrectCarName) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR_MESSAGE);
        }
    }

    public RacingCar run(MoveRule racingRule) {
        if(racingRule.isAbleToMove()) {
            carPosition++;
        }
        return new RacingCar.RacingCarBuilder(this.carName)
                .carPosition(this.carPosition)
                .build();
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public boolean isSamePosition(RacingCar other) {
        return other.carPosition == this.carPosition;
    }

    private RacingCar(RacingCarBuilder builder) {
        checkCarName(builder.carName);
        this.carName = builder.carName;
        this.carPosition = builder.carPosition;
    }

    public static class RacingCarBuilder {

        private String carName;
        private int carPosition;

        public RacingCarBuilder(String carName) {
            this.carName = carName;
        }

        public RacingCarBuilder carPosition(int carPosition) {
            this.carPosition = carPosition;
            return this;
        }

        public RacingCar build() {
            return new RacingCar(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return carPosition == racingCar.carPosition &&
                Objects.equals(carName, racingCar.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, carPosition);
    }

    @Override
    public int compareTo(RacingCar other) {
        return this.carPosition - other.getCarPosition();
    }
}
