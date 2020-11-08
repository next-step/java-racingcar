package racingcar.model;

import java.util.Objects;

public class RacingCar {

    private static final int START_LINE = 1;
    private int currentPosition;
    private String carName;

    public RacingCar(String carName) {
        this.carName = carName;
        this.currentPosition += START_LINE;
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
        return carName.equals(racingCar.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
