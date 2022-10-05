package domain;

public class Car {

    private Position position;
    private CarName carName;
    private static final int MOVING_SIZE = 1;

    public Car(CarName carName) {
        this.position = new Position(0);
        this.carName = carName;
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            this.position = new Position(position.getPosition() + MOVING_SIZE);
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getCarName() {
        return carName.getCarName();
    }
}
