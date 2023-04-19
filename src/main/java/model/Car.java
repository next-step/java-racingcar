package model;

public class Car {
    private final int START_POSITION = 0;
    private int position = START_POSITION;

    public void moveWithStrategy(MoveStrategy moveStrategy) {
        position = moveStrategy.nextPosition(position);
    }

    public int getPosition() {
        return position;
    }
}
