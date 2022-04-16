package domain;

import util.MoveStrategy;

public class Car {
    private static final int BOUNDARY_NUMBER = 4;
    private int position;

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
