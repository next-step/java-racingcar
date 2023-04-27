package carracing.domain;

import java.util.Random;

public class Car {

    private static final int MIN_MOVE_CONDITION = 4;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final Random RANDOM = new Random();

    private final String name;
    private int location;

    public Car(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다. 입력받은 이름: " + name);
        }
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void go() {
        if (RANDOM.nextInt(MAX_RANDOM_NUMBER) >= MIN_MOVE_CONDITION) {
            location++;
        }
    }

    public boolean isLocated(int distance) {
        return this.location == distance;
    }
}
