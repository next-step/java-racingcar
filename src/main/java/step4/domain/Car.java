package step4.domain;

import step4.strategy.MovableStrategy;

public class Car {
    private static final int INITIAL_POSITION_NUM = 0;

    private final Name name;
    private Position position;

    private Car(final String name) {
        this(new Name(name), new Position(INITIAL_POSITION_NUM));
    }

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(final String name) {
        return new Car(name);
    }

    public void move(MovableStrategy strategy) {
        if (strategy.movable()) {
            increasePosition();
        }
    }

    public boolean isWinner(Position winnerPosition) {
        return position.equals(winnerPosition);
    }

    private void increasePosition() {
        this.position.increase();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
