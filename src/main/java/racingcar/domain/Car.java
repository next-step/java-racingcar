package racingcar.domain;

public class Car {
    public static final int MOVEABLE_POWER = 4;
    public static final int MAX_NAME_LENGTH = 5;
    private int distance = 0;
    private final String name;

    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public void moveForwardOrStop(int inputPower) {
        if (inputPower >= MOVEABLE_POWER) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
