package game.model;

import static game.model.Position.*;

public class Car {

    private final Position position;

    private final CarName carName;

    public Car(String carName) {
        this.position = new Position(DEFAULT_POSITION);
        this.carName = new CarName(carName);
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.isPossibleToMove()) {
            this.position.increase();
        }
    }

    public Position getPosition() {
        return position;
    }

    public CarName getCarName() {
        return carName;
    }
}
