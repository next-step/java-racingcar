package race.domian;

import race.strategy.MoveStrategy;

public class Car {

    private final String name;
    private int position;
    public static final int START_POSITION = 0;
    public static final int DISTANCE_TO_MOVE_AT_ONCE = 1;

    public Car(String name) {
        this.position = START_POSITION;
        this.name = name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position += DISTANCE_TO_MOVE_AT_ONCE;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
