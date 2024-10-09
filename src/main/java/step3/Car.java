package step3;

import java.util.HashMap;
import java.util.Map;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private int position;
    private final String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public Map<String, Integer> showPosition() {
        Map<String, Integer> currentPosition = new HashMap<>();
        currentPosition.put(name, position);
        return currentPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }
}
