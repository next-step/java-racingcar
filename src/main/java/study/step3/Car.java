package study.step3;

import java.security.InvalidParameterException;

public class Car {

    private static final String CAR_NAME_RANGE_ALERT_MESSAGE = "자동차의 이름은 5글자를 초과할 수 없습니다.";
    private static final int STANDARD_VALUE_TO_MOVE = 3;

    private String name;
    private int position;


    public Car(String name) {
        if (name.length() > 5) {
            throw new InvalidParameterException(CAR_NAME_RANGE_ALERT_MESSAGE);
        }
        this.name = name;
        position = 0;
    }

    public Car(String name, int position) {
        if (name.length() > 5) {
            throw new InvalidParameterException(CAR_NAME_RANGE_ALERT_MESSAGE);
        }
        this.name = name;
        this.position = position;
    }

    int getPosition() {
        return position;
    }

    String getName() {
        return name;
    }

    int move(int randomNum) {
        if (isExceedStandard(randomNum)) {
            position++;
        }
        return position;
    }

    boolean isExceedStandard(int num) {
        return num > STANDARD_VALUE_TO_MOVE;
    }


    String printPosition() {
        return name + " : " + "-".repeat(position);
    }
}
