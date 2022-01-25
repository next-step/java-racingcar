package racingcar.model;

import racingcar.util.RandomGenerator;

public class Car {

    private final String carName;
    private String position;
    private final String CAR_NAME_LONGER_THAN_FIVE = "[ERROR] 자동차 이름은 5글자를 초과할 수 없습니다.";
    private final String CAR_NAME_LESS_THAN_ONE = "[ERROR] 자동차 이름은 최소 1글자 이상이어야 합니다. ";

    public Car(String carName) {
        validateCarNameLength(carName);
        this.carName = carName;
        this.position = "";
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() < 1) {
            throw new IllegalArgumentException(CAR_NAME_LESS_THAN_ONE);
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LONGER_THAN_FIVE);
        }
    }

    public void moveForward(int moveOrNot) {
        if (moveOrNot >= 4) {
            this.position += "-";
        }

    }

    public String getCarName() {
        return carName;
    }

    public String getPosition() {
        return position;
    }


}
