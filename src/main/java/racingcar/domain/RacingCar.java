package racingcar.domain;

import java.util.Objects;

public class RacingCar {

    private static final int START_LINE = 1;
    private int currentPosition;
    private String carName;

    public RacingCar(String carName) {
        validateCarName(carName);

        this.carName = carName;
        this.currentPosition += START_LINE;
    }

    public RacingCar(String carName, int position) {
        validateCarName(carName);

        this.carName = carName;
        this.currentPosition = position;
    }

    private void validateCarName(String carName) {
        if (isNullOrEmpty(carName) || carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름에 빈값은 사용할 수 없으며, 5자를 넘을 수 없습니다.");
        }
    }

    private boolean isNullOrEmpty(String carName) {
        return carName == null || carName.length() == 0 ? true : false;
    }

    public void move(Commander commander) {
        if(commander.moveForward()){
            currentPosition ++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return currentPosition == racingCar.currentPosition &&
                Objects.equals(carName, racingCar.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPosition, carName);
    }
}
