package racing4.domain;

import error.CustomError;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Race4Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_CONDITION = 4;

    private String name;
    private int position;

    public Race4Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static List<Race4Car> makeCarsBy(String[] carNames) {
        return Arrays.stream(carNames)
                     .map(Race4Car::new)
                     .collect(Collectors.toList());
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CustomError.EXCEED_MAX_LENGTH_ERROR.getErrorContent());
        }
    }

    public void moveForwardByCondition(int number) {
        if (isMovable(number)) {
            this.position++;
        }
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber > MOVE_CONDITION;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
