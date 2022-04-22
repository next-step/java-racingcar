package model;

public class Car {
    private Position position;
    private CarName carName;

    public Car(CarName carName) {
        this(carName, 0);
    }

    public Car(CarName carName, int position) {
        this.position = new Position(position);
        this.carName = carName;
    }

    public void move(MoveRule moveRule) {
        if (moveRule.isMoveForward()) {
            this.position.plus();
        }
    }

    public Position getPosition() {
        return position;
    }
}
