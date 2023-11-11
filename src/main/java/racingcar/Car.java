package racingcar;

import racingcar.movablestrategy.MovableStrategy;

import java.util.Objects;

public class Car {
    public static final int MOVE_DISTANCE = 1;

    private static final String RACER_NAME_DELIMITER = ",";
    public static final int MAXIMUM_NAME_LENGTH = 5;

    private int currentPosition = 0;
    private String racerName;
    private MovableStrategy movableStrategy;

    public Car(String racerName, MovableStrategy movableStrategy) {
        this.racerName = racerName;
        this.movableStrategy = movableStrategy;
    }

    public void move() {
        if (movableStrategy.movable()) {
            this.currentPosition += MOVE_DISTANCE;
        }
    }

    public int fasterPosition(int position) {
        return Math.max(this.currentPosition, position);
    }

    public boolean isSamePosition(int position) {
        return this.currentPosition == position;
    }

    public String racerName() {
        return racerName;
    }

    public int currentPosition() {
        return this.currentPosition;
    }

    public static String[] nameSplitByComma(String input) {
        String noEmptySpace = replaceAllEmptySpaceInName(input);

        String[] splitedValue = noEmptySpace.split(RACER_NAME_DELIMITER);

        for (String value : splitedValue) {
            nameMaximumLengthCheck(value);
        }
        return splitedValue;
    }

    public static String replaceAllEmptySpaceInName(String input) {
        return input.replaceAll(" ", "");
    }

    public static void nameMaximumLengthCheck(String value) {
        if (value.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAXIMUM_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return currentPosition == car.currentPosition && Objects.equals(racerName, car.racerName) && movableStrategy.getClass() == car.movableStrategy.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPosition, racerName, movableStrategy);
    }

    @Override
    public String toString() {
        return "Car{" +
                "currentPosition=" + currentPosition +
                ", racerName='" + racerName + '\'' +
                ", movableStrategy=" + movableStrategy +
                '}';
    }
}
