package step3;

public class Car {

    int location;
    MoveStrategy moveStrategy;

    Car(MoveStrategy moveStrategy) {
        this.location = 0;
        this.moveStrategy = moveStrategy;
    }

    public int getCurrentLocation() {
        return this.location;
    }

    public void moveForwardOnChance() {
        if (moveStrategy.move()) {
            this.location += 1;
        }
    }
}
