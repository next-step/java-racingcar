package racingcar.domain.car;

import racingcar.domain.game.strategy.MoveStrategy;

public class Car {
    private static final int DEFAULT_MOVE_POSITION = 1;
    private final Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public String getCarName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position;
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position += DEFAULT_MOVE_POSITION;
        }
    }

    public boolean isEqualPosition(int otherPosition) {
        return this.position == otherPosition;
    }
}
