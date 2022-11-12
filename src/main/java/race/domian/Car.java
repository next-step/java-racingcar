package race.domian;

import race.strategy.MoveStrategy;

public class Car {

    private final String name;
    private int position;
    public static final int START_POSITION = 0;
    public static final int DISTANCE_TO_MOVE_AT_ONCE = 1;
    private static final String CHARACTER_LIMIT_ERROR = "이름은 5자를 초과할 수 없습니다.";
    private static final int CHARACTER_LIMIT = 5;

    public Car(String name) {
        this.position = START_POSITION;
        this.name = validateName(name);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position += DISTANCE_TO_MOVE_AT_ONCE;
        }
    }

    private String validateName(String name) {
        if (name.length() > CHARACTER_LIMIT) {
            throw new IllegalArgumentException(CHARACTER_LIMIT_ERROR);
        }
        return name;
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
