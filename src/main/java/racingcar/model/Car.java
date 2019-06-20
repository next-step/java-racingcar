package racingcar.model;

public class Car {

    public static final int MOVING_CONDITION = 4;
    public static final int DEFAULT_POSITION = 1;
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        validateEmpty(name);
        return new Car(name, DEFAULT_POSITION);
    }

    private static void validateEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름을 입력하세요.");
        }
    }

    public int move(int power) {
        if (isRunning(power)) {
            position++;
        }
        return position;
    }

    private boolean isRunning(int power) {
        return MOVING_CONDITION <= power;
    }

    public boolean isMatchPosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}