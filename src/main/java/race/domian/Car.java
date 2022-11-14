package race.domian;

import race.strategy.MoveStrategy;

public class Car {

    public static final int DISTANCE_TO_MOVE_AT_ONCE = 1;

    private Name name;
    private Position position;

    public Car(String name) {
        this.position = new Position(0);
        this.name = new Name(name);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position.move();
        }
    }

    public boolean isWinner(int maxPosition) {
        return position.isMaxPosition(maxPosition);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}
