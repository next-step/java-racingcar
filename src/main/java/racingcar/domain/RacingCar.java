package racingcar.domain;

import java.util.Objects;
import racingcar.view.RacingCarOutput;

public class RacingCar implements Movable{

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

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int randomNumber) {
        if (isMovable(randomNumber)) {
            position++;
        }
    }

    @Override
    public boolean isMovable(int randomNumber) {
        return randomNumber >= THRESHOLD;
    }

    private void validate(String name) {
        if (isOver(name) || isCorrectNameSize(name)) {
            throw new IllegalArgumentException(RacingCarOutput.ERROR_CAR_NAME_OVER_OR_EMPTY);
        }
    }

    private boolean isCorrectNameSize(String name) {
        return name.length() > NAME_MAX_SIZE;
    }

    private boolean isOver(String name) {
        return Objects.isNull(name) || name.isEmpty();
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }
}
