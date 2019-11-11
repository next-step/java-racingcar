package racing.model;

import java.util.Objects;

public class Car {

    private static final String COLON_CHARACTER = " : ";
    private static final String MOVE_CAR_EXPRESSION = "- ";
    private static final String COMMA_SPACE_CHARACTER = ", ";
    private static final int MOVE_CONDITION_NUMBER = 4;
    private static final int MOVE_NUMBER = 1;

    private final String carName;

    private int position;

    public Car(final String carName) {
        this.carName = carName;
        this.position = RacingConstant.ZERO_NUMBER;
    }

    public int move(int movableValue) {
        if (isMovable(movableValue)) {
            return this.position += MOVE_NUMBER;
        }
        return position;
    }

    private boolean isMovable(int movableValue) {
        return movableValue >= MOVE_CONDITION_NUMBER;
    }

    public int comparePositionWith(int winnerPosition) {
        return Math.max(this.position, winnerPosition);
    }

    public boolean isBiggerThanWinnerPosition(int winnerPosition) {
        return this.position > winnerPosition;
    }

    public boolean isEqualWinnerPosition(int winnerPosition) {
        return this.position == winnerPosition;
    }

    public String printNameAndPosition() {
        return this.carName + COLON_CHARACTER + printPosition();
    }

    private String printPosition() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            stringBuilder.append(MOVE_CAR_EXPRESSION);
        }
        return stringBuilder.toString();
    }

    public StringBuilder printWinners(StringBuilder stringBuilder, int winnerPosition) {
        if (isBiggerThanWinnerPosition(winnerPosition)) {
            stringBuilder = new StringBuilder(this.carName);
        }

        if (isEqualWinnerPosition(winnerPosition)) {
            stringBuilder.append(COMMA_SPACE_CHARACTER)
                    .append(this.carName);
        }
        return stringBuilder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return MOVE_CONDITION_NUMBER == car.MOVE_CONDITION_NUMBER &&
                position == car.position &&
                Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MOVE_CONDITION_NUMBER, carName, position);
    }

}
