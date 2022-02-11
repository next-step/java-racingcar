package racingcar.domain;

import java.util.Objects;
import racingcar.view.RacingCarOutput;

public class RacingCar{

    private static final int DEFAULT_POSITION = 0;
    private static final int THRESHOLD = 4;
    private static final int NAME_MAX_SIZE = 5;

    private String name;
    private int position;

    public RacingCar(String name) {
        this(name, DEFAULT_POSITION);
    }

    public RacingCar(String name, int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    private void validate(String name) {
        if (isOver(name) || isCorrectNameSize(name)) {
            throw new IllegalArgumentException(RacingCarOutput.ERROR_CAR_NAME_OVER_OR_EMPTY);
        }
    }

    private boolean isOver(String name) {
        return Objects.isNull(name) || name.isEmpty();
    }

    private boolean isCorrectNameSize(String name) {
        return name.length() > NAME_MAX_SIZE;
    }

    public RacingCar moveForward(final Movable movable) {
        if (movable.isMovable()) {
            return new RacingCar(name, position + 1);
        }
        return this;
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
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
        return position == racingCar.position && Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
