package racing.model;

import racing.module.MoveStrategy;

public class Car {
    private final CarName carName;
    private final Position position;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position();
    }

    public void attempt(MoveStrategy strategy) {
        if (strategy.canMove()) {
            position.move();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isWinner(int maxPosition) {
        return position.isMaxPosition(maxPosition);
    }

    public String getCarName() {
        return carName.getName();
    }
}
