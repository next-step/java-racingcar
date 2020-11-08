package racing_car;

import racing_car.strategy.MoveStrategy;

public class Car {

    private int location;
    private final String name;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.move()) {
            goForward();
        }
    }

    private void goForward() {
        location++;
    }

    public int getLocation() {
        return location;
    }

    public Record exportRecord() {
        return new Record(this.name, this.location);
    }

}
