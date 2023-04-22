package racingcar.domain;

public class Car {
    private static final String CAR_NAME_LENGTH_LIMIT_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다. input: %s";
    private int position;
    private final String name;

    public Car(String name) {
        this(name, 0);
    }
    public Car(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(String.format(CAR_NAME_LENGTH_LIMIT_MESSAGE, name));
        }
        this.name = name;
        this.position = position;
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

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }
}
