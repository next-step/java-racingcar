package domain;

public class Car {

    private final CarName carName;
    private Position position;

    public Car(CarName carName) {
        this.position = new Position(0);
        this.carName = carName;
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            this.position = position.movePosition();
        }
    }

    public Position getPosition() {
        return position;
    }

    public int getIntValuePosition() {
        return position.getPosition();
    }

    public String getCarName() {
        return carName.getCarName();
    }
}
