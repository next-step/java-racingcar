package step3;

public class Car {

    private String name;
    private int location;
    MoveStrategy moveStrategy;

    Car(MoveStrategy moveStrategy) {
        this.location = 0;
        this.moveStrategy = moveStrategy;
    }

    Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.location = 0;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return this.name;
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
