package carracing.model;

public class Car {
    private static final int POSITION_INITIAL_VALUE = 0;
    private static final int MOVE_CONDITION = 4;
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String CAR_NAME_EXCEPTION_MESSAGE = "자동차 이름이 5자 이상입니다";

    private String name;
    private int position;

    public Car(String name) {
        this(name, POSITION_INITIAL_VALUE);
    }

    public Car(String name, int position) {
        validateCarNameLength(name);
        this.name = name;
        this.position = position;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() >= NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(CAR_NAME_EXCEPTION_MESSAGE);
        }
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }

    public boolean isIn(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
