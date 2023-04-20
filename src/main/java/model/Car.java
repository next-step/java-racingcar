package model;

public class Car {
    private final int START_POSITION = 0;
    private int position = START_POSITION;

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void moveWithStrategy(MoveStrategy moveStrategy) {
        position = moveStrategy.nextPosition(position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
