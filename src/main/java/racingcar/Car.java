package racingcar;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car() {
        this("");
    }

    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "글자를 넘을 수 없다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}
