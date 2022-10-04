package racingcar;

import racingcar.strategy.MovingStrategy;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private int position;
    private String name;

    public Car(String name) {
        validateNameLength(name);
        this.position = 0;
        this.name = name;
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            return ++this.position;
        }
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }
}
