package step5;

import step5.interfaces.MoveStrategy;

public class Car {
    private int location = 0;
    private final CarName carName;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public int getLocation() {
        return this.location;
    }

    public CarName getCarName() {
        return carName;
    }

    public void goOrStop(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.progress();
        }
    }

    private void progress() {
        this.location += 1;
    }
}
