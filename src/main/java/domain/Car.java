package domain;

import util.MoveStrategy;

public class Car {
    private final Position position = new Position();
    private final String name;

    public Car(String name) {
        this.name = name;
        validateCarName();
    }

    private void validateCarName() {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 빈칸이거나 공백일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position.goForward();
        }
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean equalPosition(Position position) {
        return this.position.equals(position);
    }
}
