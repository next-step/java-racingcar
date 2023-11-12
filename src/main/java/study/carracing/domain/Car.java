package study.carracing.domain;

import study.carracing.util.MoveStrategy;

public class Car {

    private static final String PROGRESS_DASH = "-";

    private final Position position;

    private final Name name;

    public Car(Name name) {
        this(new Position(), name);
    }

    public Car(Position position, Name name) {
        this.position = position;
        this.name = name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position.plusPosition();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public int compareToMaxPosition(int maxPosition) {
        return this.position.compareToMaxPosition(maxPosition);
    }

    public boolean isSame(int maxPosition) {
        return this.position.isSame(maxPosition);
    }

    @Override
    public String toString() {
        return getName() + " : " + PROGRESS_DASH.repeat(getPosition());
    }
}
