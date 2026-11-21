package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("valid name is required [" + name + "]");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("too long for name [" + name + "]");
        }
        if (position < 0) {
            throw new IllegalArgumentException("position can not be negative value [" + position + "]");
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

    public void move(int number) {
        if (number >= THRESHOLD) {
            position++;
        }
    }

    public CarStatus toCarStatus() {
        return new CarStatus(name, position);
    }
}
