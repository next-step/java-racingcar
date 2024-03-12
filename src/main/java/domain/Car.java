package domain;

public class Car {

    private final Position position;
    private final MoveStrategy moveStrategy;
    private final String name;
    private static final String DEFAULT_NAME = "noop";

    public Car(MoveStrategy moveStrategy) {
        this(DEFAULT_NAME, moveStrategy);
    }

    public Car(String name, MoveStrategy moveStrategy) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = new Position();
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.moveable()) {
            position.moveForward();
        }
    }

    public Position position() {
        return this.position;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, "-".repeat(position.getValue() + 1));
    }

    public String getName() {
        return this.name;
    }
}
