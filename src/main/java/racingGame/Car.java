package racingGame;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private Position position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = Position.start();
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다: " + name);
        }
    }

    public void move(MoveStrategy strategy) {
        if (strategy.movable()) {
            position = position.move();
        }
    }

    public String name() {
        return name;
    }

    public int position() {
        return position.value();
    }

    public boolean isAt(int target) {
        return position.isSame(target);
    }

    public boolean isFurtherThan(int value) {
        return position.isGreaterThan(value);
    }

}
