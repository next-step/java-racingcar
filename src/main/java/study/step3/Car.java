package study.step3;

import java.security.InvalidParameterException;
import java.util.Random;

public class Car {

    private static final String CAR_NAME_RANGE_ALERT_MESSAGE = "자동차의 이름은 5글자를 초과할 수 없습니다.";
    private static final int STANDARD_VALUE_TO_MOVE = 3;
    private static final int RANGE_FOR_RANDOM = 10;
    private Random random = new Random();
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

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    boolean move() {
        if (isExceedStandard(getRandomInt())) {
            position++;
            return true;
        }
        return false;
    }

    boolean isExceedStandard(int num) {
        return num > STANDARD_VALUE_TO_MOVE;
    }

    public int getRandomInt() throws IllegalArgumentException {
        return random.nextInt(RANGE_FOR_RANDOM);
    }

    public String printPosition() {
        return name + " : " + "-".repeat(position);
    }
}
