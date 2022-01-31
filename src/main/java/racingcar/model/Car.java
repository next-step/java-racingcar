package racingcar.model;

public class Car {

    private static final String CAR_NAME_LONGER_THAN_FIVE = "[ERROR] 자동차 이름은 5글자를 초과할 수 없습니다.";
    private static final String CAR_NAME_LESS_THAN_ONE = "[ERROR] 자동차 이름은 최소 1글자 이상이어야 합니다. ";
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MOVE_FORWARD_CONDITION = 4;
    private static final int DEFAULT_POSITION = 0;

    private final String carName;
    private int position;

    public Car(String carName) {
        this(carName, DEFAULT_POSITION);
    }

    public Car(String carName, int position) {
        validateCarNameLength(carName);
        this.carName = carName;
        this.position = position;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() < MINIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LESS_THAN_ONE);
        }
        if (carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LONGER_THAN_FIVE);
        }
    }

    public void moveForward(int moveOrNot) {
        if (moveOrNot >= MOVE_FORWARD_CONDITION) {
            this.position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

}
