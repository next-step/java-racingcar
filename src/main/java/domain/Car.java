package domain;

public class Car {
    private int distance = 0;
    private final MoveStrategy moveStrategy;
    private final String owner;

    public Car(String owner, MoveStrategy moveStrategy) {
        this.owner = owner;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.isCanMove()) {
            distance += 1;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getOwner() {
        return owner;
    }
}
