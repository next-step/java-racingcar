package model;

public class Car {
    private static final int CAR_MOVE_BOUNDARY = 4;
    private CarName carName;
    private Position position;

    public Car(int position, String name) {
        this.position = new Position(position);
        this.carName = new CarName(name);
    }

    private boolean canMoveForward(int randomNumber) {
        return randomNumber >= CAR_MOVE_BOUNDARY;
    }

    public void tryMoveForward(int randomNumber) {
        if (canMoveForward(randomNumber)) {
            position.forward();
        }
    }

    public String name() {
        return carName.toString();
    }

    public String toString() {
        return String.format("%s : %s", carName, position);
    }

    public Position max(Position maxPosition) {
        return position.max(maxPosition);
    }

    public boolean isMaxPosition(Position maxPosition) {
        return position.equals(maxPosition);
    }
}
