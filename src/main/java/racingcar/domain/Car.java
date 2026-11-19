package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int THRESHOLD = 4;
    private int position = 0;
    private final String name;

    public Car(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("valid name is required [" + name + "]");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("too long for name [" + name + "]");
        }
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int number) {
        if (number >= THRESHOLD) {
            position++;
        }
    }
}
