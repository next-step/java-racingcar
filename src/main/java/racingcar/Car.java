package racingcar;

public class Car {
    private static final String CAR_NAME_LENGTH_LIMIT_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private int position;
    private final String name;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_LIMIT_MESSAGE);
        }
        this.name = name;
    }

    public void move() {
        position++;
    }
    public int position() {
        return position;
    }
    public String name() {
        return name;
    }
}
