package study.carracing.domain;

import study.carracing.exceptions.InvalidNameException;

public class Car {

    private static final int INITIAL_POSITION = 1;
    private static final String PROGRESS_DASH = "-";
    private static final int MOVE_CONDITION_NUMBER = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private int position;
    private final String name;

    public Car(String name) {
        this(INITIAL_POSITION, name);
    }

    public Car(int position, String name) {
        validateNameBlank(name.trim());
        validateNameLength(name.trim());
        this.position = position;
        this.name = name;
    }

    public void move(int value) {
        if (value >= MOVE_CONDITION_NUMBER) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    private void validateNameBlank(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidNameException("자동차의 이름이 입력되지 않았습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameException("자동차의 이름은 5자를 초과할 수 없습니다." + name);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + PROGRESS_DASH.repeat(position);
    }
}
