package race;

public class Car {
    private final CarName carName;
    private final Position position;
    private final MoveStrategy moveStrategy;

    public Car(CarName carName, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.position = new Position();
        this.moveStrategy = moveStrategy;
    }

    public void moveForward() {
        if (moveStrategy.canMove()) {
            position.add();
        }
    }

    public CarName getCarName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }
}
