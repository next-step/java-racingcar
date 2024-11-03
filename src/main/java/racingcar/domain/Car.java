package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private Position position;

    public Car(String name) {
        this(name, new Position(0));
    }

    // 주생성자
    public Car(String name, Position position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position = position.increment();
        }
    }

    public Map<String, Integer> showCurrentPosition() {
        Map<String, Integer> currentPosition = new HashMap<>();
        currentPosition.put(name, position.getPosition());
        return currentPosition;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }
}
