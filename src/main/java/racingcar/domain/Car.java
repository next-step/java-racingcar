package racingcar.domain;

import racingcar.movablestrategy.MovableStrategy;

public class Car {
    public static final int MOVE_DISTANCE = 1;
    private static final String RACER_NAME_DELIMITER = ",";
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final int INITIAL_POSITION = 0;
    private int currentPosition = 0;
    private String racerName;

    public Car() {
        this("", INITIAL_POSITION);
    }

    public Car(int position) {
        this("", position);
    }

    public Car(String racerName) {
        this(racerName, INITIAL_POSITION);
    }

    public Car(String racerName, int position) {
        String noEmptySpaceName = replaceAllEmptySpaceInName(racerName);

        nameMaximumLengthCheck(noEmptySpaceName);

        this.racerName = noEmptySpaceName;
        this.currentPosition = position;
    }

    public CarStatDTO move(MovableStrategy movableStrategy) {
        if (movableStrategy.movable()) {
            this.currentPosition += MOVE_DISTANCE;
        }
        CarStatDTO carStatDTO = new CarStatDTO(this.racerName, this.currentPosition);
        return carStatDTO;
    }

    public CarStatDTO carStatDTO() {
        CarStatDTO carStatDTO = new CarStatDTO(this.racerName, this.currentPosition);
        return carStatDTO;
    }

    public int fasterPosition(int position) {
        return Math.max(this.currentPosition, position);
    }

    public boolean isSamePosition(int position) {
        return this.currentPosition == position;
    }

    public static String[] nameSplitByDelimiter(String input) {
        String[] splitedValue = input.split(RACER_NAME_DELIMITER);

        return splitedValue;
    }

    private static String replaceAllEmptySpaceInName(String input) {
        return input.replaceAll(" ", "");
    }

    private static void nameMaximumLengthCheck(String value) {
        if (value.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAXIMUM_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }
}
