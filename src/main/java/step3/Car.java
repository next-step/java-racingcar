package step3;

public class Car {

    private static final int MIN_MOVE_CONDITION = 4;
    private static final int MAX_CAR_NAME_LENGTH = 5;

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

    public void go(int distance) {
        if (distance >= MIN_MOVE_CONDITION) {
            location += distance;
        }
    }

    public boolean isLocated(int distance) {
        return this.location == distance;
    }
}
