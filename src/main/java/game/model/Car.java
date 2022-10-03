package game.model;

public class Car {

    private final Position position;

    private final CarName carName;

    public Car(String carName) {
        this.position = new Position(0);
        this.carName = new CarName(carName);
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.isPossibleToMove()) {
            this.position.increase();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getCarName() {
        return carName.getName();
    }
}
