package racing.domain;

import racing.strategy.MoveStrategy;

public class Car {
    private CarName carName;
    private int distance;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public String getName() {
        return carName.getCarName();
    }

    public int getDistance() {
        return distance;
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMoveable()) {
            this.distance++;
        }
    }
}
