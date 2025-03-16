package edu.nextstep.camp.carracing;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final String MOVE_SYMBOL = "-";

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 null이거나 빈 문자열일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void move(int number) {
        if (number >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getCurrentPositionString() {
        return String.format("%s : %s", name, MOVE_SYMBOL.repeat(position));
    }
}
