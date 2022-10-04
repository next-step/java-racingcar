package racingcar.domain;

import racingcar.exception.RacingCarNameOverSizeException;
import racingcar.strategy.MovingStrategy;

import java.util.Objects;

public class RacingCar {

    public static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int distance;

    public RacingCar(String name) {
        if (Objects.isNull(name) || name.length() == 0 || name.length() > MAX_NAME_LENGTH) {
            throw new RacingCarNameOverSizeException();
        }

        this.name = name;
        this.distance = 0;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return distance == racingCar.distance && Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
